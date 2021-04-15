package loggInn;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PassordUtil {

	private static final int SALT_LENGTH = 24;
	private static final int HASH_ITERATIONS = 1000;
	private static final String KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
	private static final String VALID_PASSWORD_PATTERN = "^.{4,}$";
	private static final int KEY_LENGTH = 40;
	private static final String SPRAAK ="UTF-8";
	
	public String krypterPassord(String passord) throws IllegalArgumentException {
    	if (passord == null || !passord.matches(VALID_PASSWORD_PATTERN)) {
    		throw new IllegalArgumentException("Ugyldig passord. Passordet må matche " + VALID_PASSWORD_PATTERN);
    	}
        byte[] salt = genererTilfeldigSalt();
        return krypterMedSalt(salt, passord);
    }

    public boolean sjekkPassord(String passord, String kryptert) {
    
        byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
        return krypterMedSalt(salt, passord).equals(kryptert);
    }
    
    /*--- Private hjelpemetoder ---*/

	public String krypterMedSalt(byte[] salt, String password) {
		
		String kryptert = null;
		
		SecretKeyFactory skf;
		try {
			char[] passchars = password.toCharArray();
			
			PBEKeySpec pks = new PBEKeySpec(passchars, salt, HASH_ITERATIONS, KEY_LENGTH);
			skf = SecretKeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
			byte[] keyhash = skf.generateSecret(pks).getEncoded();
			
	        byte[] saltPlusKeyHash = leggSammen(salt, keyhash);
	        kryptert = Base64.getEncoder().encodeToString(saltPlusKeyHash);
		
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();	
		}
        
        return kryptert;
		
	}

    public byte[] genererTilfeldigSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
        // for evt. SecureRandom.getInstance("SHA1PRNG"); => m� catche ex
        new SecureRandom().nextBytes(salt);
//        System.out.println("Tilfeldig salt = " + Base64.getEncoder().encodeToString(salt));
        return salt;
    }

    private byte[] hentUtSaltFraKryptertStreng(String kryptert) {
        byte[] saltPlusDigest = Base64.getDecoder().decode(kryptert);
        byte[] salt = Arrays.copyOf(saltPlusDigest, SALT_LENGTH);
        return salt;
    }
    
    private byte[] leggSammen(byte[] tabell1, byte[] tabell2) {
        byte[] enOgTo = new byte[tabell1.length + tabell2.length];
        System.arraycopy(tabell1, 0, enOgTo, 0, tabell1.length);
        System.arraycopy(tabell2, 0, enOgTo, tabell1.length, tabell2.length);
        return enOgTo;
    }
	
}
