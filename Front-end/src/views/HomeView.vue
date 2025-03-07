<script setup></script>

<template>
  <main>
    <div class="sfondo">
      <div class="img-container">
        <img src="../../public/robot4.webp" id="gif" alt="non funziona" />
      </div>
    </div>

    <div class="container">
      <div class="row">
        <!-- Titolo -->
        <div class="col-12 mt-5 mb-3">
          <h1 class="text-center">Le ultime news</h1>
        </div>

        <!-- Inizio carosello -->
        <div
          id="carouselExampleCaptions"
          class="carousel slide"
          data-bs-ride="carousel"
          data-bs-interval="5000"
        >
          <div class="carousel-indicators">
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="2"
              aria-label="Slide 3"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="../../public/slide-1.png" class="d-block w-100" alt="..." />
              <div class="carousel-caption d-none d-md-block">
                <h1>Nebula Knight</h1>
                <p>
                  L'ultima entry del team
                  <strong class="yellow">Galactic Guardians</strong>
                </p>
              </div>
            </div>
            <div class="carousel-item">
              <img src="../../public/slide-2.png" class="d-block w-100" alt="..." />
              <div class="carousel-caption d-none d-md-block">
                <h1 class="yellow ombra">Galactic Guardians</h1>
                <p class="ombra">
                  Ed ecco qui il team con la loro mascotte
                  <strong class="yellow ombra">Wall-E</strong>
                </p>
              </div>
            </div>
            <div class="carousel-item">
              <img src="../../public/slide-3.jpg" class="d-block w-100" alt="..." />
              <div class="carousel-caption d-none d-md-block"></div>
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        <!-- Fine carosello -->

        <!-- Titolo 2 -->
        <div class="col-12">
          <h1 class="text-center yellow mt-5 mb-3">I prossimi tornei</h1>
        </div>

        <!-- Paragrafo tornei -->
        <div class="col-6">
        </div>
        <div class="col-6">
          <img src="../../public/robot-viola.webp" alt="">
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>
.img-container {
  height: calc(100vh - 100px);
}

#gif {
  width: 100%;
  height: 100%;
  object-fit: cover; /* Ritaglia l'immagine per riempire il contenitore */
  object-position: top; /* Mostra la parte superiore della GIF */
}

main {
  color: yellow;
}

h1 {
  color: yellow;
}

.yellow {
  color: yellow;
}

.ombra {
  text-shadow: -1px -1px 0 rgb(0, 0, 0), 1px -1px 0 rgb(0, 0, 0), -1px 1px 0 rgb(0, 0, 0),
    1px 1px 0 rgb(0, 0, 0);
}
.blu {
  color: blue;
}

p {
  font-size: 20px;
}
</style>
