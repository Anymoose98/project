<script>
import axios from "axios";
export default {
  data() {
    return {
      tornei: [],
      torneo: {
        img: "percorso_dinamico.jpg" // Qui metti l'URL dinamico dell'immagine
      },
      fallbackImg: "../../public/torneo-new-york.jpg"
    };
  },
  mounted() {
    this.chiamatatornei();
    this.created();
  },
  methods: {
    chiamatatornei() {
      axios.get("http://localhost:8080/tornei").then((response) => {
        console.log(response.data);
        this.tornei = response.data;
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
    <div v-if="$route.query.message" class="alert alert-success">
      {{ $route.query.message }}
    </div>
    <div class="circuit-overlay">
      <div class="container position-relative">
        <router-link to="/tornei/add">
          <button class="add-button position-absolute">
            <i class="fa-solid fa-plus"></i>
          </button>
        </router-link>
        <div class="row justify-content-center">
          <h1 class="neon-title col-12 text-center">TORNEI</h1>
          <div class="torneo-grid">
            <div v-for="torneo in tornei" :key="torneo.id">
              <router-link class="text-warning" :to="'/tornei/' + torneo.id">
                <div class="card shadow-sm team-card">
                  <img :src="torneo.img || fallbackImg"
                       class="card-img-top team-image"
                       alt="Foto Torneo"
                       @error="handleError" />
                  <div class="card-body">
                    <div class="background-overlay"></div>
                    <h5 class="card-title">{{ torneo.nome }}</h5>
                    <p class="card-text">
                      <strong>Data Inizio: </strong>{{ torneo.dataInizio }}
                    </p>
                    <p class="card-text">
                      <strong>Data Fine: </strong>{{ torneo.dataFine }}
                    </p>
                    <p class="card-text">
                      <strong>Luogo: </strong>{{ torneo.geografica }}
                    </p>
                  </div>
                </div>
              </router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>
.team-card {
  border-radius: 12px;
  overflow: hidden;
  transition: transform 0.3s ease-in-out;
  display: flex; /* Usa flex per uniformare l'altezza interna */
  flex-direction: column;
  height: 100%; /* Assicura che la card occupi tutta l'altezza disponibile */
}

.torneo-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr)); /* Sostituisce col-md-4 */
  gap: 25px;
  padding: 0 20px;
  align-items: stretch; /* Fa sì che tutte le card nella griglia abbiano la stessa altezza */
}

.card-body {
  background-image: url("../../public/sfondo-team.webp");
  background-size: cover;
  position: relative;
  color: white;
  flex-grow: 1; /* Permette al card-body di espandersi per occupare lo spazio rimanente */
  display: flex;
  flex-direction: column;
  justify-content: flex-start; /* Allinea il contenuto all'inizio */
}

p {
  position: relative;
  z-index: 2;
  margin: 5px 0; /* Spaziatura uniforme tra i paragrafi */
}

h5 {
  position: relative;
  z-index: 2;
  margin-bottom: 10px; /* Spazio sotto il titolo */
}

.background-overlay {
  position: absolute;
  top: 0;
  z-index: 1; /* Corretto da 2 a 1 per stare sotto il testo */
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.neon-title {
  font-family: 'Orbitron', sans-serif;
  font-size: 2.8rem;
  color: #ff0000;
  text-shadow: 0 0 10px #590000, 0 0 20px #590000, 0 0 40px #590000;
  margin-bottom: 30px;
}

.row {
  padding: 30px;
}

.team-card:hover {
  transform: scale(1.05);
}

.team-image {
  height: 200px;
  object-fit: cover;
}

a {
  text-decoration: none;
  color: yellow;
}

.add-button {
  right: 40px;
  background: #ff0000;
  color: #1a1a2e;
  padding: 10px 20px;
  border: none;
  border-radius: 25px;
  font-family: 'Orbitron', sans-serif;
  font-size: 1rem;
  text-transform: uppercase;
  cursor: pointer;
  box-shadow: 0 0 10px #590000;
  transition: all 0.3s ease;
  z-index: 3;
  top: 30px;
  height: 52px;
}
</style>