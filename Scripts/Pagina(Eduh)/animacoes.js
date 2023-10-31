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

// Inicia as animações
increaseSize.start();
rotate.start();
fadeIn.start();
