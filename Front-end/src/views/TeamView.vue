<script>
import axios from "axios";
export default {
  data() {
    return {
      teams: [],
      team: {
        img: "",
      },
      fallbackImg: "../../public/slide-2.png",
    };
  },
  mounted() {
    this.chiamatateam();
    this.created();
  },
  methods: {
    chiamatateam() {
      axios.get("http://localhost:8080/teams").then((response) => {
        console.log(response.data);
        this.teams = response.data;
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
    <div class="container position-relative">
      <router-link to="/team/add">
        <button class="add-button position-absolute">
          <i class="fa-solid fa-plus"></i>
        </button>
      </router-link>
      <div class="row justify-content-center">
        <h1 class="neon-title col-12 text-center">TEAM</h1>
        <div class="robot-grid">
          <div class="" v-for="team in teams" :key="team.id">
            <router-link class="text-warning" :to="'/team/' + team.id">
              <div class="card shadow-sm team-card">
                <img v-if="team.img" :src="team.img" alt="Cyber Crushers Banner" class="card-img-top team-image" />
                <img v-else :src="fallbackImg" alt="Default Banner" class="card-img-top team-image" />
                <div class="card-body">
                  <div class="background-overlay"></div>
                  <h5 class="card-title">{{ team.nome }}</h5>
                  <p class="card-text">
                    <strong>Membri: </strong>{{ team.membri }}
                  </p>
                  <p class="card-text">
                    <strong>Punteggio team: </strong>{{ team.punteggioTeam }}
                  </p>
                  <p class="card-text">
                    <strong>Tornei vinti: </strong>{{ team.torneiVinti }}
                  </p>
                </div>
              </div>
            </router-link>
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

.robot-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
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
  z-index: 1;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.team-card:hover {
  transform: scale(1.05);
}

.team-image {
  height: 200px;
  object-fit: cover;
}

.neon-title {
  font-family: 'Orbitron', sans-serif;
  font-size: 2.8rem;
  color: #2bff00;
  text-shadow: 0 0 10px #2bff00, 0 0 20px #2bff00, 0 0 40px #2bff00;
  margin-bottom: 30px;
}

a {
  text-decoration: none;
  color: white;
}

.add-button {
  right: 40px;
  background: #2bff00;
  color: #1a1a2e;
  padding: 10px 20px;
  border: none;
  border-radius: 25px;
  font-family: 'Orbitron', sans-serif;
  font-size: 1rem;
  text-transform: uppercase;
  cursor: pointer;
  box-shadow: 0 0 10px #2bff00;
  transition: all 0.3s ease;
  z-index: 3;
  top: 30px;
  height: 52px;
}

.row {
  padding: 30px;
}
</style>