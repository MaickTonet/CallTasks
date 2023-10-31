// Importa a biblioteca de animações
import { anime } from "animejs";

// Define as animações
const increaseSize = anime({
  targets: ".sidebar-button",
  duration: 0.5,
  easing: "ease-in-out",
  scale: {
    from: 1,
    to: 1.1,
  },
});

const rotate = anime({
  targets: ".sidebar-button",
  duration: 1,
  easing: "linear",
  transform: {
    from: "rotate(0deg)",
    to: "rotate(360deg)",
  },
});

const fadeIn = anime({
  targets: ".sidebar-button",
  duration: 1,
  easing: "linear",
  opacity: {
    from: 0,
    to: 1,
  },
});

// Importa o método `addEventListener()` //Erro
const addEventListener = window.addEventListener.
// Importa o método `addEventListener()` //Erro
const addEventListener = window.addEventListener.bind(window);

// Adiciona um evento de clique aos botões de navegação
addEventListener("click", event => {
  // Obtém o elemento que foi clicado
  const element = event.target;

  // Se o elemento for um link
  if (element.tagName === "A") {
    // Obtém o id da seção que o link representa
    const sectionId = element.getAttribute("href");

    // Redireciona para a página com o id da seção
    window.location.href = sectionId;
  }
});



// Inicia as animações
increaseSize.start();
rotate.start();
fadeIn.start();
