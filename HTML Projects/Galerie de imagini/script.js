const carousel = document.querySelector('.carousel');
const carouselItems = carousel.querySelectorAll('.carousel__item');
const prevButton = document.querySelector('.carousel__button--prev');
const nextButton = document.querySelector('.carousel__button--next');
let currentIndex = 0;
const totalItems = carouselItems.length;
function showItem(index) {
  if (index < 0 || index >= totalItems) {
    return;
  }
  carouselItems.forEach(item => {
    item.style.transform = `translateX(-${index * 100}%)`;
  });
  currentIndex = index;
  if (currentIndex === totalItems - 1) {
    nextButton.addEventListener('click', () => {
      showItem(0);
    }, { once: true });
  }
  if (currentIndex === 0) {
    prevButton.addEventListener('click', () => {
      showItem(totalItems - 1);
    }, { once: true });
  }
}
prevButton.addEventListener('click', () => {
  showItem(currentIndex - 1);
});
nextButton.addEventListener('click', () => {
  showItem(currentIndex + 1);
});
showItem(currentIndex);
