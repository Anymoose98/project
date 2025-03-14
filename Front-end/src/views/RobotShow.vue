<script>
import axios from "axios";
export default {
  data() {
    return {
      robot: [],
      Id2: this.$route.params.id,
      
    };
  },
  mounted() {
    this.chiamatarobot();
    this.created();
  },
  methods: {
    chiamatarobot() {
      const robotId = this.$route.params.id;
      axios.get(`http://localhost:8080/robots/${robotId}`).then((response) => {

        this.robot = response.data;
      });
    },
    created() {
      window.scrollTo(0, 0);
    },

    async deleteRobot() {
      const robotId = this.$route.params.id;
      try {
        // Send DELETE request to the API

        await axios.delete(`http://localhost:8080/robots/${robotId}`);

        // Redirect to /robot with a success message
        this.$router.push({
          path: "/robot",
          query: { message: "Robot eliminato con successo!" },
        });
      } catch (error) {
        console.error("Errore durante l'eliminazione del robot:", error);
        // Optionally handle the error (e.g., show an error message)
        this.$router.push({
          path: "/robot",
          query: { message: "Errore durante l'eliminazione del robot." },
        });
      }
    },
  },
};


</script>
<template>
  <main class="">
    <div class="tech-arena py-4">

      <div class="dark-circuit"></div>
      <div class="arena-content">
        <div class="d-flex justify-content-between align-items-center">
          <button class="delete-button ms-5" @click = deleteRobot><i class="fa-solid fa-trash-can"></i></button>
          <h1 class="neon-title">Dettagli Robot</h1>
          <router-link :to='"/robot/edit/" + robot.id'> <button class="customize-button ms-5"> <i class="fa-solid fa-edit"> </i></button></router-link>
        </div>
        <div class="robot-display" v-if="robot">
          <div class="mech-card">
            <div class="mech-plate">
              <img :src="robot.img" alt="Robot" class="mech-avatar" />
              <h2 class="mech-name">{{ robot.nome }}</h2>
              <p class="mech-spec">Modello: {{ robot.modello }}</p>
              <!-- /<p class="mech-spec">Materiale: {{ robot.materiale }}</p> -->
              <div class="mech-stats">
                <p class="stat-line">Peso: <span class="stat-value">{{ robot.peso }} kg</span></p>
                <p class="stat-line">Velocità: <span class="stat-value">{{ robot.velocita }} km/h</span></p>
                <p class="stat-line">Altezza: <span class="stat-value">{{ robot.altezza }} m</span></p>
                <p class="stat-line">Stile Combattimento: <span class="stat-value">{{ robot.stileDiCombattimento
                }}</span></p>
                <p class="stat-line">Punteggio: <span class="stat-value">{{ robot.punteggioRobot }}</span></p>
                <p class="stat-line">Team: <span class="stat-value">{{ robot.teamRobotica ? robot.teamRobotica.nome :
                  'N/A' }}</span></p>
                <p class="stat-line">Tornei: <span class="stat-value">{{robot.tornei ? robot.tornei.map(t =>
                  t.nome).join(', ') : 'Nessuno'}}</span></p>
              </div>
            </div>
          </div>
        </div>
  
  
        <router-link to="/robot" class="back-button">Torna alla Galleria</router-link>
      </div>
    </div>
  </main>
</template>
<style scoped>
.tech-arena {
  position: relative;
  background-size: cover;
  background: url('https://via.placeholder.com/1920x1080') no-repeat center/cover;
  background-position: center;
  overflow: hidden;
}

.dark-circuit {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, rgba(10, 25, 47, 0.8), rgba(0, 0, 0, 0.9));
  opacity: 0.85;
}

.arena-content {
  position: relative;
  z-index: 2;

  text-align: center;
}

.neon-title {
  font-family: 'Orbitron', sans-serif;
  font-size: 3rem;
  color: #00ffcc;
  text-shadow: 0 0 10px #00ffcc, 0 0 20px #00ffcc, 0 0 40px #00ffcc;
  margin-bottom: 40px;
}

.robot-display {
  display: flex;
  justify-content: center;
}

.mech-card {
  position: relative;
  width: 320px;
  background: linear-gradient(145deg, #0d1b2a, #1b263b);
  border: 3px solid #00ffcc;
  border-radius: 15px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6), inset 0 0 12px rgba(0, 255, 204, 0.3);
  transition: transform 0.4s ease, box-shadow 0.4s ease;
}

.mech-card:hover {
  transform: scale(1.08) rotate(1.5deg);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.8), 0 0 40px rgba(0, 255, 204, 0.5);
  border-color: #ff007a;
}

.mech-plate {
  padding: 20px;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #e0e0e0;
}

.mech-avatar {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 10px;
  border: 4px solid #ff007a;
  box-shadow: 0 0 20px rgba(255, 0, 122, 0.6);
}

.mech-name {
  font-size: 2rem;
  font-weight: bold;
  text-transform: uppercase;
  color: #00ffcc;
  text-shadow: 1px 1px 6px rgba(0, 255, 204, 0.8);
  margin: 15px 0 10px;
}

.mech-spec {
  font-size: 1.2rem;
  font-style: italic;
  color: #ff007a;
  margin-bottom: 15px;
}

.mech-stats {
  background: rgba(255, 255, 255, 0.08);
  padding: 15px;
  border-radius: 8px;
  border: 1px solid rgba(0, 255, 204, 0.4);
}

.stat-line {
  margin: 8px 0;
  font-size: 1rem;
}

.stat-value {
  color: #ffd700;
  font-weight: bold;
}

.mech-badge {
  position: absolute;
  bottom: 15px;
  right: 15px;
  background: #ff007a;
  color: white;
  padding: 6px 12px;
  border-radius: 25px;
  font-size: 0.9rem;
  box-shadow: 0 0 12px rgba(255, 0, 122, 0.7);
  animation: pulse 1.5s infinite;
}

.loading-signal {
  font-size: 1.5rem;
  color: #00ffcc;
  text-shadow: 0 0 10px #00ffcc;
}

.error-signal {
  color: #ff5555;
  font-size: 1.3rem;
  margin-top: 20px;
  text-shadow: 0 0 5px #ff5555;
}

.back-button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background: #00ffcc;
  color: #000000;
  text-decoration: none;
  border-radius: 5px;
  font-weight: bold;
  box-shadow: 0 0 10px #00ffcc;
  transition: all 0.3s ease;
}

.back-button:hover {
  background: #ff007a;
  color: white;
  box-shadow: 0 0 15px #ff007a;
}

.delete-button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background: #00ffcc;
  color: rgb(0, 0, 0);
  text-decoration: none;
  border-radius: 15px;
  font-weight: bold;
  box-shadow: 0 0 10px #00ffcc;
  transition: all 0.3s ease;
  position: relative;
  bottom: 28px;
}

.customize-button {
  display: inline-block;
  margin-top: 20px;
  padding: 10px 20px;
  background: #00ffcc;
  color: #000000;
  text-decoration: none;
  border-radius: 15px;
  font-weight: bold;
  box-shadow: 0 0 10px #00ffcc;
  transition: all 0.3s ease;
  position: relative;
  right: 48px;
  bottom: 28px;

}

@keyframes pulse {
  0% {
    box-shadow: 0 0 12px rgba(255, 0, 122, 0.7);
  }

  50% {
    box-shadow: 0 0 20px rgba(255, 0, 122, 1);
  }

  100% {
    box-shadow: 0 0 12px rgba(255, 0, 122, 0.7);
  }
}
</style>