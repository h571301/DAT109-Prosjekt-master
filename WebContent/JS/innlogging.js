let f1 = document.querySelector('.f1');
let f2 = document.querySelector('.f2');
let f3 = document.querySelector('.f3');
let f4 = document.querySelector('.f4');

let b1 = document.querySelector('.b1');
let b2 = document.querySelector('.b2');
let b3 = document.querySelector('.b3');
let b4 = document.querySelector('.b4');

let formClass = document.querySelector('.form-class');
let numberClass = document.querySelector('.number-class');

b1.addEventListener('click', () => {
  numberClass.classList.value = 'hidden';
  formClass.classList.toggle('hidden');
  f1.classList.toggle('hidden');
});

b2.addEventListener('click', () => {
  numberClass.classList.value = 'hidden';
  formClass.classList.toggle('hidden');
  f1.classList.toggle('hidden');
  f2.classList.toggle('hidden');
});

b3.addEventListener('click', () => {
  numberClass.classList.value = 'hidden';
  formClass.classList.toggle('hidden');
  f1.classList.toggle('hidden');
  f2.classList.toggle('hidden');
  f3.classList.toggle('hidden');
});

b4.addEventListener('click', () => {
  numberClass.classList.value = 'hidden';
  formClass.classList.toggle('hidden');
  f1.classList.toggle('hidden');
  f2.classList.toggle('hidden');
  f3.classList.toggle('hidden');
  f4.classList.toggle('hidden');
});
