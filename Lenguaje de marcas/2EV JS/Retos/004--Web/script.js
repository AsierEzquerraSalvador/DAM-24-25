// Variables globales
const moviesContainer = document.getElementById('movies-container');
const filterGenre = document.getElementById('filter-genre');
const searchTitle = document.getElementById('search-title');
const searchButton = document.getElementById('search-button');
const sortButton = document.getElementById('sort-button');

// Botones específicos del encabezado
const filterButtons = {
  all: document.getElementById('filter-all'),
  animation: document.getElementById('filter-animation'),
  action: document.getElementById('filter-action'),
  scifi: document.getElementById('filter-scifi'),
  romance: document.getElementById('filter-romance'),
  horror: document.getElementById('filter-horror'),  // Botón para Terror
  comedy: document.getElementById('filter-comedy'),  // Botón para Comedia
};

// Sección de trailer y sinopsis
const trailerContainer = document.getElementById('movie-trailer'); // Contenedor del trailer
const movieTitle = document.getElementById('movie-title'); // Título de la película
const movieYear = document.getElementById('movie-year'); // Año de la película
const movieGenre = document.getElementById('movie-genre'); // Género de la película
const movieSynopsis = document.getElementById('movie-synopsis'); // Sinopsis de la película
const trailerVideo = document.getElementById('trailer-video'); // Reproductor de video

// Estado actual
let movies = [];
let filteredMovies = [];
let isSortedAsc = true;

// Información de los trailers y sinopsis
const movieDetails = {
  'The Batman': {
    trailer: "./VIDEOS/Batman.mp4",
    synopsis: "En su segundo año como el Caballero Oscuro, Bruce Wayne (Robert Pattinson) investiga una serie de asesinatos cometidos por el villano Riddler (Paul Dano), que desvela una red de corrupción en Gotham City. Mientras se enfrenta a criminales como el mafioso Carmine Falcone (John Turturro) y la enigmática Selina Kyle / Catwoman (Zoë Kravitz), Batman lucha con sus propios demonios y descubre oscuros secretos sobre la muerte de sus padres. La película presenta a un Batman más detectivesco y reflexivo en su misión por restaurar la justicia en una ciudad en crisis..",
  },
  'The Avengers': {
    trailer: "https://www.youtube.com/embed/eOrNdBpGMv8",
    synopsis: "Un equipo de héroes con habilidades extraordinarias se une para proteger al mundo de una amenaza que podría destruirlo, liderados por Nick Fury de S.H.I.E.L.D.",
  },
  'Joker': {
    trailer: "https://www.youtube.com/embed/zAGVQLHvwOY",
    synopsis: "Arthur Fleck, un hombre desilusionado y rechazado por la sociedad, se convierte en el infame villano 'Joker' después de una serie de eventos que lo llevan al límite.",
  },
  // Puedes añadir más películas con trailers y sinopsis aquí
};

// Cargar las películas
async function loadMovies() {
  try {
    const response = await fetch('peliculas.json');
    movies = await response.json();
    console.log('Películas cargadas:', movies); // Log para depuración
    filteredMovies = [...movies];
    renderMovies(filteredMovies);
    renderTopRatedMovies(); // Cargar las mejores películas
  } catch (error) {
    console.error('Error cargando las películas:', error);
  }
}

// Renderizar las películas
function renderMovies(movies) {
  moviesContainer.innerHTML = '';
  if (movies.length === 0) {
    moviesContainer.innerHTML = '<p>No se encontraron películas.</p>';
    return;
  }

  movies.forEach(movie => {
    const movieCard = document.createElement('div');
    movieCard.className = 'movie-card';

    movieCard.innerHTML = `
      <img src="${movie.poster}" alt="${movie.titulo}">
      <h3>${movie.titulo}</h3>
      <p>Género: ${movie.genero}</p>
      <p>Año: ${movie.año}</p>
      <p class="imdb">IMDB: ${movie.imdb}</p> <!-- Nota en amarillo -->
    `;

    // Hacer que el clic en una película cambie el trailer y la sinopsis
    movieCard.addEventListener('click', () => {
      changeMovie(movie);
    });

    moviesContainer.appendChild(movieCard);
  });
}

// Función para actualizar el trailer y la sinopsis cuando se selecciona una película
function changeMovie(movie) {
  // Verificar si existe la película en el objeto movieDetails
  const movieDetail = movieDetails[movie.titulo] || { trailer: '', synopsis: '' };

  console.log('Detalles de la película:', movieDetail); // Agregar log para depuración

  if (movieDetail.trailer && movieDetail.synopsis) {
    trailerVideo.src = movieDetail.trailer;
    movieTitle.textContent = movie.titulo;
    movieYear.textContent = movie.año;
    movieGenre.textContent = movie.genero;
    movieSynopsis.textContent = movieDetail.synopsis;
  } else {
    console.error('No se encontraron detalles para esta película.');
    trailerVideo.src = ''; // Limpiar el trailer si no hay detalles
    movieTitle.textContent = 'Sin detalles disponibles';
    movieYear.textContent = '';
    movieGenre.textContent = '';
    movieSynopsis.textContent = 'No disponible';
  }
}

// Filtrar por género (dropdown)
filterGenre.addEventListener('change', () => {
  const genre = filterGenre.value;
  filteredMovies = genre === 'all' ? movies : movies.filter(movie => movie.genero === genre);
  renderMovies(filteredMovies);
});

// Filtrar por botones de género
Object.keys(filterButtons).forEach(key => {
  filterButtons[key].addEventListener('click', () => {
    const genreMap = {
      all: 'all',
      animation: 'Animación',
      action: 'Acción',
      scifi: 'Ciencia Ficción',
      romance: 'Romance',
      horror: 'Terror',
      comedy: 'Comedia',
    };

    const genre = genreMap[key];
    filteredMovies = genre === 'all' ? movies : movies.filter(movie => movie.genero === genre);
    renderMovies(filteredMovies);
  });
});

// Buscar por título
searchButton.addEventListener('click', () => {
  const title = searchTitle.value.toLowerCase();
  filteredMovies = movies.filter(movie => movie.titulo.toLowerCase().includes(title));
  renderMovies(filteredMovies);
});

// Ordenar por año
sortButton.addEventListener('click', () => {
  filteredMovies.sort((a, b) => isSortedAsc ? a.año - b.año : b.año - a.año);
  isSortedAsc = !isSortedAsc;
  renderMovies(filteredMovies);
});

// Renderizar las mejores películas
function renderTopRatedMovies() {
  const topRatedContainer = document.getElementById('top-rated-container');
  
  // Filtrar y ordenar por calificación (IMDB) de mayor a menor
  const topRatedMovies = [...movies].sort((a, b) => b.imdb - a.imdb).slice(0, 5); // Top 5

  topRatedContainer.innerHTML = '';

  topRatedMovies.forEach(movie => {
    const topMovieCard = document.createElement('div');
    topMovieCard.className = 'movie-card';

    topMovieCard.innerHTML = `
      <img src="${movie.poster}" alt="${movie.titulo}">
      <h3>${movie.titulo}</h3>
      <p class="imdb">IMDB: ${movie.imdb}</p> <!-- Nota en amarillo -->
    `;

    topRatedContainer.appendChild(topMovieCard);
  });
}

// Inicializar
loadMovies();
