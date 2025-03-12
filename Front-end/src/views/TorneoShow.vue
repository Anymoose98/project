<script>
import axios from "axios";
export default {
    data() {
        return {
            torneo: [],
        };
    },
    mounted() {
        this.chiamatatorneo();
    },
    methods: {
        chiamatatorneo() {
            const torneoId = this.$route.params.id;
            axios.get(`http://localhost:8080/tornei/${torneoId}`).then((response) => {

                this.torneo = response.data;
            });
        },
        created() {
            window.scrollTo(0, 0);
        },
    },
};
</script>
<template>
    <main class="py-4">
        


        <div class="tournament-showcase">
            <div class="circuit-overlay"></div>
            <div class="showdown-content">
                
                <h1 class="showdown-title"> Torneo </h1>
                <div class="tournament-card">
                    <div class="card-header">
                        <img src="../../public/2.jpeg" alt="Western Robotics Banner" class="banner-img" />
                    </div>
                    <div class="card-body">
                        <h2 class="tournament-name">{{ torneo.nome }}</h2>
                        <p class="tournament-dates">
                            <span class="label">Dal:</span> {{ torneo.dataInizio }}
                            <span class="label">Al:</span> {{ torneo.dataFine }}
                        </p>
                        <p class="tournament-region">
                            <span class="label">Regione:</span> {{ torneo.geografica }}
                        </p>
                        <div class="tournament-details">
                            <p class="detail-text">Ecco l'alba di una nuova era: le macchine titaniche si sfidano nei
                                tornei di combattimenti tra robot! 🤖🔥</p>
                        </div>

                    </div>
                </div>
                <router-link class="text-warning" to="/tornei">
                    <button class="join-btn">Torna ai tornei</button>
                </router-link>
            </div>
        </div>
    </main>
</template>
<style scoped>
tournament-showcase {
    position: relative;
    min-height: 80vh;
    background: url('https://via.placeholder.com/1920x1080') no-repeat center/cover;
    overflow: hidden;
    padding: 40px;
}

.circuit-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(to bottom, rgba(34, 19, 0, 0.7), rgba(0, 0, 0, 0.9));
    opacity: 0.9;
    z-index: 1;
}

.showdown-content {
    position: relative;
    z-index: 2;
    text-align: center;
}

.showdown-title {
    font-family: 'Cinzel', serif;
    font-size: 3rem;
    color: #ffcc00;
    text-shadow: 0 0 10px #ffcc00, 0 0 20px #ff4500;
    margin-bottom: 40px;
}

.tournament-card {
    max-width: 600px;
    margin: 0 auto;
    background: linear-gradient(to bottom, rgba(10, 25, 47, 0.8), rgba(0, 0, 0, 0.9));
    border: 3px solid #00ffcc;
    border-radius: 15px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6), inset 0 0 12px rgba(0, 255, 204, 0.3);
    overflow: hidden;
    transition: transform 0.3s ease;
}

.tournament-card:hover {
    transform: scale(1.03);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.8), 0 0 20px rgba(0, 255, 204, 0.5);
}

.card-header {
    position: relative;
}

.banner-img {
    width: 100%;
    height: auto;
    object-fit: cover;
    border-bottom: 2px solid #ff4500;
}

.card-body {
    padding: 20px;
    color: #e0e0e0;
}

.tournament-name {
    font-family: 'Orbitron', sans-serif;
    font-size: 1.8rem;
    color: #00ffcc;
    text-shadow: 1px 1px 6px rgba(0, 255, 204, 0.8);
    margin-bottom: 15px;
}

.tournament-dates,
.tournament-region {
    font-size: 1.1rem;
    margin: 10px 0;
}

.label {
    color: #ff4500;
    font-weight: bold;
}

.tournament-details {
    margin-top: 20px;
}

.detail-text {
    font-style: italic;
    color: #ffd700;
    text-shadow: 0 0 5px rgba(255, 215, 0, 0.5);
}

.join-btn {
    margin-top: 15px;
    padding: 10px 20px;
    background: #ff007a;
    color: white;
    border: none;
    border-radius: 25px;
    font-family: 'Orbitron', sans-serif;
    font-size: 1rem;
    text-transform: uppercase;
    cursor: pointer;
    box-shadow: 0 0 10px rgba(255, 0, 122, 0.6);
    transition: all 0.3s ease;
}

.join-btn:hover {
    background: #00ffcc;
    color: #2e1a00;
    box-shadow: 0 0 15px rgba(0, 255, 204, 0.8);
}
</style>
