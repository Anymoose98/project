<script>
import axios from "axios";
export default {
  data() {
    return {
      tornei: [],
    };
  },
  mounted() {
    this.chiamatatornei();
  },
  methods: {
    chiamatatornei() {
      axios.get("http://localhost:8080/tornei").then((response) => {
        console.log(response.data);
        this.tornei = response.data;
      });
    },
  },
};
</script>
<template>
  <main>
    <div class="circuit-overlay">
      <div class="container">
        <div class="row justify-content-center">
          <h1 class="neon-title mt-5 col-12 text-center">TORNEI</h1>
          <div class="col-md-4 my-4" v-for="torneo in tornei" :key="tornei.id">
            <router-link class="text-warning" :to='"/tornei/" + torneo.id'>

              <div class="card shadow-sm team-card">

                <img src="../../public/slide-2.png" class="card-img-top team-image" alt="Foto Team" />
                <div class="card-body">
                  <div class="background-overlay"></div>
                  <h5 class="card-title">{{ torneo.nome }}</h5>
                  <p class="card-text">
                    <strong>Data Inizio: </strong>{{ torneo.dataInizio }}
                  </p>
                  <p class="card-text">
                    <strong>Data fine: </strong>{{ torneo.dataFine }}
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
  </main>
</template>

<style scoped>
.team-card {
  border-radius: 12px;
  overflow: hidden;
  transition: transform 0.3s ease-in-out;
}

.card-body {
  background-image: url("../../public/sfondo-team.webp");
  background-size: cover;
  position: relative;
  color: white;
}

p {
  position: relative;
  z-index: 2;
}

h5 {
  position: relative;
  z-index: 2;
}

.background-overlay {
  position: absolute;
  top: 0;
  z-index: 2;
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


/* .circuit-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, rgba(34, 19, 0, 0.7), rgba(0, 0, 0, 0.9));
  opacity: 0.9;
  z-index: 3;
} */


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
</style>
