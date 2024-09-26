const carouselImages = document.querySelector('.carousel-images');
const prevButton = document.querySelector('.prev');
const nextButton = document.querySelector('.next');

let offset = 0;
const slideWidth = 260; // Largura da imagem (250px) + margem (10px)
const totalSlides = carouselImages.children.length;

// Função para mover o carrossel
function moveCarousel() {
	carouselImages.style.transition = 'transform 0.3s ease-in-out';
	carouselImages.style.transform = `translateX(${offset}px)`;
}

// Função para pular para o início ou fim, criando o efeito de loop infinito
function loopCarousel() {
	if (offset < -(slideWidth * (totalSlides - 1))) {
		offset = 0;
		carouselImages.style.transition = 'none'; // Remove a animação para o "teleporte" parecer instantâneo
		carouselImages.style.transform = `translateX(${offset}px)`;
	} else if (offset > 0) {
		offset = -(slideWidth * (totalSlides - 1));
		carouselImages.style.transition = 'none'; // Remove a animação para o "teleporte" parecer instantâneo
		carouselImages.style.transform = `translateX(${offset}px)`;
	}
}

prevButton.addEventListener('click', () => {
	offset += slideWidth;
	moveCarousel();
	setTimeout(loopCarousel, 300); // Aguarda a animação para "teleportar" ao início/fim
});

nextButton.addEventListener('click', () => {
	offset -= slideWidth;
	moveCarousel();
	setTimeout(loopCarousel, 300); // Aguarda a animação para "teleportar" ao início/fim
});
