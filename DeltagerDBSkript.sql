DROP SCHEMA IF EXISTS DeltagerPU CASCADE;
CREATE SCHEMA DeltagerPU;
SET search_path = DeltagerPU;

CREATE TABLE DeltagerPU.deltager 
(
    brukernavn  CHARACTER VARYING(40),
    passord  CHARACTER VARYING(100),
    epost  CHARACTER VARYING(40),
    PRIMARY KEY (brukernavn)
);

