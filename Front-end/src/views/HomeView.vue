<script>
import axios from "axios";
export default {
  data() {
    return {
      robots: [],
    };
  },
  mounted() {
    this.chiamatarobots();
  },
  methods: {
    chiamatarobots() {
      axios.get("http://localhost:8080/robots").then((response) => {
        this.robots = response.data;
      });
    },
    created() {
      window.scrollTo(0, 0);
    },
  },
};
</script>

<template>
  <main>




    <div class="container">
      <div class="row">
        <!-- Titolo -->
        <div class="col-12 mt-5 mb-3">
          <h1 class="text-center text-warning">Le ultime news</h1>
        </div>

        <!-- Inizio carosello -->
        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" data-bs-interval="5000">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
              aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
              aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
              aria-label="Slide 3"></button>
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
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
            data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        <!-- Fine carosello -->

        <!-- Titolo 2 -->
        <div class="col-12">
          <h1 class="text-center text-warning mt-5 mb-3">I prossimi tornei</h1>
        </div>

        <!-- Paragrafo tornei -->
        <div class="col-50 d-flex flex-column">
          <div class="col-laterale">
            <!-- <span class="data-torneo">01/07/2025 - 31/09/2025</span> -->
            <img src="../../public/1.jpeg" alt="" class="img-laterali" />
          </div>
          <div class="col-laterale">
            <!-- <span class="data-torneo">01/08/2024 - 31/06/2025</span> -->
            <img src="../../public/2.jpeg" alt="" class="img-laterali" />
          </div>
          <div class="col-laterale">
            <!-- <span class="data-torneo">01/08/2024 - 31/06/2025</span> -->
            <img src="../../public/3.jpeg" alt="" class="img-laterali" />
          </div>
        </div>
        <div class="col-50">
          <img src="../../public/robot-viola.jpg" alt="" class="robot-viola" />
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>
.tech-arena {
  min-height: 100vh;
  background-image: url('https://via.placeholder.com/1920x1080');
  background-position: center;
  overflow: hidden;
}

/* .dark-circuit {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, rgba(10, 25, 47, 0.8), rgba(0, 0, 0, 0.9)); 
  z-index: 1;
  opacity: 0.85;
} */

.arena-content {
  position: relative;
  z-index: 2;
  padding: 30px;
  text-align: center;
}

.neon-title {
  font-family: 'Orbitron', sans-serif;
  font-size: 2.8rem;
  color: #00ffcc;
  text-shadow: 0 0 10px #00ffcc, 0 0 20px #00ffcc, 0 0 40px #00ffcc;
  margin-bottom: 30px;
}

.robot-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 25px;
  padding: 0 20px;
}

.img-container {
  height: calc(100vh - 100px);
}

#gif {
  width: 100%;
  height: 100%;
  object-fit: cover;
  /* Ritaglia l'immagine per riempire il contenitore */
  object-position: top;
  /* Mostra la parte superiore della GIF */
}

.data-torneo {
  position: absolute;
  bottom: 10px;
  right: 10px;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  padding: 5px;
  font-size: 14px;
  font-weight: bold;
  border-radius: 5px;
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
  text-shadow: -1px -1px 0 rgb(0, 0, 0), 1px -1px 0 rgb(0, 0, 0),
    -1px 1px 0 rgb(0, 0, 0), 1px 1px 0 rgb(0, 0, 0);
}

.blu {
  color: blue;
}

p {
  font-size: 20px;
}

.col-50 {
  width: 50%;
  padding: 0;
}

.robot-viola {
  width: 100%;
  height: auto;
  object-fit: cover;
}

.col-laterale {
  flex: 1;
  /* Distribuisce lo spazio in modo uniforme */
  display: flex;
  position: relative;
}

.img-laterali {
  width: 100%;
  height: auto;
  object-fit: cover;
}

.mech-card {
  position: relative;
  width: 260px;
  height: 380px;
  background: linear-gradient(145deg, #0d1b2a, #1b263b);
  border: 2px solid #00ffcc;
  border-radius: 12px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.5), inset 0 0 10px rgba(0, 255, 204, 0.2);
  transition: all 0.4s ease;
}

.mech-card:hover {
  transform: scale(1.05) rotate(1deg);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.7), 0 0 30px rgba(0, 255, 204, 0.4);
  border-color: #ff007a;
}

.mech-plate {
  padding: 15px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #e0e0e0;
}

.mech-avatar {
  width: 100%;
  height: 160px;
  object-fit: cover;
  border-radius: 8px;
  border: 3px solid #ff007a;
  box-shadow: 0 0 15px rgba(255, 0, 122, 0.5);
}

.mech-name {
  font-size: 1.2rem;
  font-weight: bold;
  text-transform: uppercase;
  color: #00ffcc;
  text-shadow: 1px 1px 5px rgba(0, 255, 204, 0.7);
  margin: 10px 0 5px;
}

.mech-spec {
  font-size: 1rem;
  font-style: italic;
  color: #ff007a;
  margin-bottom: 10px;
}

.mech-stats {
  background: rgba(255, 255, 255, 0.05);
  padding: 10px;
  border-radius: 6px;
  border: 1px solid rgba(0, 255, 204, 0.3);
}

.stat-line {
  margin: 5px 0;
  font-size: 0.9rem;
}

.stat-value {
  color: #ffd700;
  font-weight: bold;
}

.mech-badge {
  position: absolute;
  bottom: 10px;
  right: 10px;
  background: #ff007a;
  color: white;
  padding: 5px 10px;
  border-radius: 20px;
  font-size: 0.8rem;
  box-shadow: 0 0 10px rgba(255, 0, 122, 0.6);
}

.error-signal {
  color: #ff5555;
  font-size: 1.2rem;
  margin-top: 20px;
  text-shadow: 0 0 5px #ff5555;
}

a {
  text-decoration: none;
  color: yellow;
}
</style>
