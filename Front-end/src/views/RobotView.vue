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
        this.created();
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
};</script>

<template>
    <main class="position relative">
        <div v-if="$route.query.message" class="alert alert-success">
            {{ $route.query.message }}
        </div>


        <div class="container position-relative">
            <router-link class="text-warning" to="/robot/add">
                <button class="add-button position-absolute ">
                    <i class="fa-solid fa-plus"></i>
                </button>
            </router-link>
            <div class="row justify-content-center">
                <!-- Card per ogni robot -->
                <div class="tech-arena">
                    <div class="dark-circuit"></div>
                    <div class="arena-content">
                        <div class="d-flex justify-content-center align-items-center ">
                            <h1 class="neon-title">ROBOT</h1>
                        </div>
                        <div class="robot-grid">
                            <div class="mech-card" v-for="robot in robots" :key="robot.id">
                                <router-link class="text-warning" :to='"/robot/" + robot.id'>
                                    <div class="mech-plate">
                                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgm5atAI2kO90UD6hp53Bn1YVkG4zStEWA8Q&s"
                                            alt="Robot" class="mech-avatar" />
                                        <h2 class="mech-name">{{ robot.nome }}</h2>
                                        <p class="mech-spec">Modello: {{ robot.modello }}</p>
                                        <div class="mech-stats">
                                            <p class="stat-line">
                                                Peso: <span class="stat-value">{{ robot.peso }} kg</span>
                                            </p>
                                            <p class="stat-line">
                                                Velocità:
                                                <span class="stat-value">{{ robot.velocita }} m/s</span>
                                            </p>
                                            <p class="stat-line">
                                                Punteggio:
                                                <span class="stat-value">{{ robot.punteggioRobot }}</span>
                                            </p>
                                        </div>
                                    </div>
                                </router-link>

                            </div>
                        </div>
                    </div>
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
    margin-left: 50px;
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

.add-button {
    right: 85px;
    background: #00ffcc;
    color: #1a1a2e;
    padding: 10px 20px;
    border: none;
    border-radius: 25px;
    font-family: 'Orbitron', sans-serif;
    font-size: 1rem;
    text-transform: uppercase;
    cursor: pointer;
    box-shadow: 0 0 10px rgba(0, 255, 204, 0.6);
    transition: all 0.3s ease;
    z-index: 3;
    top: 30px;
    height: 52px;

}
</style>