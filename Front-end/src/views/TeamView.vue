<script>
import axios from "axios";
export default {
  data() {
    return {
      teams: [],
    };
  },
  mounted() {
    this.chiamatateam();
  },
  methods: {
    chiamatateam() {
      axios.get("http://localhost:8080/teams").then((response) => {
        console.log(response.data);
        this.teams = response.data;
      });
    },
  },
};
</script>
<template>
  <main>
    <div class="container">
      <div class="row justify-content-center">
        <h1 class="neon-title mt-5 col-12 text-center">TEAM</h1>
        <div class="col-md-4 my-4" v-for="team in teams" :key="team.id">

          <div class="card shadow-sm team-card">
            
            <img
              src="../../public/slide-2.png"
              class="card-img-top team-image"
              alt="Foto Team"
            />
            <div class="card-body">
              <div class="background-overlay"></div>
              <h5 class="card-title">{{ team.nome }}</h5>
              <p class="card-text">
                <strong>Membri: </strong>{{ team.membri }}
              </p>
              <p class="card-text">
                <strong>punteggio team: </strong>{{ team.punteggioTeam }}
              </p>
              <p class="card-text">
                <strong>tornei vinti: </strong>{{ team.torneiVinti }}
              </p>
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
}
.card-body{
  background-image: url("../../public/sfondo-team.webp");
  background-size: cover;
  position:relative;
  color: white;
}
p{
  position:relative;
  z-index: 2;
}
h5{
  position:relative;
  z-index: 2;
}
.background-overlay{
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
</style>
