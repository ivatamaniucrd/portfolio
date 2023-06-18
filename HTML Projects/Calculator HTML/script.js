const display = document.querySelector('.input');
const buttons = document.querySelectorAll('button');

buttons.forEach(button => {
  button.addEventListener('click', () => {
    if (button.classList.contains('operator')) {
      display.value += ` ${button.value} `;
    } else if (button.classList.contains('clear')) {
      display.value = '';
    } else if (button.classList.contains('equal')) {
      display.value = eval(display.value);
    } else {
      display.value += button.value;
    }
  });
});
