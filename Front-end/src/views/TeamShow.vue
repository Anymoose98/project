<script>
import axios from "axios";
export default {
    data() {
        return {
            team: [],
        };
    },
    mounted() {
        this.chiamatateam();
        this.created();
    },
    methods: {
        chiamatateam() {
            const teamid = this.$route.params.id;
            axios.get(`http://localhost:8080/teams/${teamid}`).then((response) => {

                this.team = response.data;
            });
        },
        created() {
            window.scrollTo(0, 0);
        },

        async deleteTeam() {
            const teamId = this.$route.params.id;
            try {
                // Send DELETE request to the API

                await axios.delete(`http://localhost:8080/teams/${teamId}`);

                // Redirect to /robot with a success message
                this.$router.push({
                    path: "/team",
                    query: { message: "Team eliminato con successo!" },
                });
            } catch (error) {
                console.error("Errore durante l'eliminazione del team:", error);
                // Optionally handle the error (e.g., show an error message)
                this.$router.push({
                    path: "/team",
                    query: { message: "Errore durante l'eliminazione del team." },
                });
            }
        },

    },
};
</script>
<template>
    <main>
        <div class=" py-4 team-showcase">
            <div class="circuit-overlay"></div>
            <div class="team-content">
                <div class="d-flex justify-content-between align-items-center">
                    <button class="delete-button ms-5" @click=deleteTeam><i class="fa-solid fa-trash-can"></i></button>

                    <h1 class="team-section-title">TEAM</h1>
                    <button class="customize-button ms-5"> <i class="fa-solid fa-edit"> </i></button>
                </div>
                <div class="team-card">
                    <div class="card-header">
                        <img :src="team.img" alt="Cyber Crushers Banner" class="banner-img" />
                    </div>
                    <div class="card-body">
                        <h2 class="team-name">{{ team.nome }}</h2>
                        <div class="team-stats">
                            <p class="stat-line">
                                <span class="label">Membri:</span> {{ team.membri }}
                            </p>
                            <p class="stat-line">
                                <span class="label">Punteggio Team:</span> {{ team.punteggioTeam }}
                            </p>
                            <p class="stat-line">
                                <span class="label">Tornei Vinti:</span> {{ team.torneiVinti }}
                            </p>
                        </div>
                        <div class="team-details">
                            <p class="detail-text">Pronti a distruggere il campo con forza cibernetica!</p>
                        </div>
                    </div>
                </div>
                <router-link class="text-warning" to="/team">
                    <button class="view-btn">Torna ai team</button>
                </router-link>
            </div>
        </div>
    </main>
</template>
<style scoped>
.team-showcase {
    position: relative;
    background-size: cover;
    background: url('https://via.placeholder.com/1920x1080') no-repeat center/cover;
    background-position: center;
    overflow: hidden;
}

.circuit-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(to bottom, rgba(0, 67, 23, 0.8), rgba(0, 0, 0, 0.9));
    opacity: 0.85;
}

.team-content {
    position: relative;
    z-index: 2;
    text-align: center;
}

.team-section-title {
    font-family: 'Orbitron', sans-serif;
    font-size: 2.8rem;
    color: #2bff00;

    text-shadow: 0 0 10px #2bff00, 0 0 20px #2bff00;
    margin-bottom: 40px;
}

.team-card {
    max-width: 500px;
    margin: 0 auto;
    background: linear-gradient(145deg, #1a1a2e, #2e2e4d);
    border: 3px solid #2bff00;
    border-radius: 15px;
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6), inset 0 0 12px rgba(255, 0, 122, 0.3);
    overflow: hidden;
    transition: transform 0.3s ease;
}

.team-card:hover {
    transform: scale(1.03);
    box-shadow: 0 12px 24px rgba(0, 0, 0, 0.8), 0 0 20px rgba(255, 0, 122, 0.5);
}

.card-header {
    position: relative;
}

.banner-img {
    width: 100%;
    height: auto;
    object-fit: cover;
    border-bottom: 2px solid #00ffcc;
}

.card-body {
    padding: 20px;
    color: #e0e0e0;
}

.team-name {
    font-family: 'Orbitron', sans-serif;
    font-size: 1.7rem;
    color: #ffffff;
    text-shadow: 1px 1px 6px #ffffff;
    margin-bottom: 15px;
}

.team-stats {
    background: rgba(255, 255, 255, 0.05);
    padding: 10px;
    border-radius: 6px;
    border: 1px solid rgba(255, 0, 122, 0.3);
    margin-bottom: 15px;
}

.stat-line {
    margin: 8px 0;
    font-size: 1rem;
    color: #ffffff;
}

.label {
    color: #2bff00;
    font-weight: bold;
}

.team-details {
    margin-top: 20px;
}

.detail-text {
    font-style: italic;
    color: #ffffff;
    text-shadow: 0 0 5px rgba(255, 255, 255, 0.5);
}

.view-btn {
    margin-top: 15px;
    padding: 10px 20px;
    background: #2bff00;
    color: #1a1a2e;
    border: none;
    border-radius: 25px;
    font-family: 'Orbitron', sans-serif;
    font-size: 1rem;
    text-transform: uppercase;
    cursor: pointer;
    box-shadow: 0 0 10px #2bff00;
    transition: all 0.3s ease;
}

.view-btn:hover {
    background: #ff007a;
    color: white;
    box-shadow: 0 0 15px rgba(255, 0, 122, 0.8);
}

.delete-button {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background: #2bff00;
    color: rgb(0, 0, 0);
    text-decoration: none;
    border-radius: 15px;
    font-weight: bold;
    box-shadow: 0 0 10px #2bff00;
    transition: all 0.3s ease;
    position: relative;
    bottom: 28px;
}

.customize-button {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background: #2bff00;
    color: #000000;
    ;
    text-decoration: none;
    border-radius: 15px;
    font-weight: bold;
    box-shadow: 0 0 10px #2bff00;
    transition: all 0.3s ease;
    position: relative;
    right: 48px;
    bottom: 28px;

}
</style>