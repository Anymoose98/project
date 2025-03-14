<script>
import axios from "axios";
export default {
    data() {
        return {
            team: {
                nome: "",
                membri: "",
                punteggioTeam: "",
                torneiVinti: "",
                img: ""
            }
        };
    },
    mounted() {
        this.loadTeamData();
    },
    methods: {
        loadTeamData() {
            const teamId = this.$route.params.id;
            axios.get(`http://localhost:8080/teams/${teamId}`)
                .then((response) => {
                    const data = response.data;
                    this.team = {
                        nome: data.nome,
                        membri: data.membri,
                        punteggioTeam: data.punteggioTeam,
                        torneiVinti: data.torneiVinti,
                        img: data.img
                    };
                })
                .catch((error) => {
                    console.error("Errore nel caricamento del team:", error);
                });
        },

        updateTeam() {
            const teamId = this.$route.params.id;
            const teamData = {
                nome: this.team.nome,
                membri: parseInt(this.team.membri),
                punteggioTeam: parseInt(this.team.punteggioTeam),
                torneiVinti: parseInt(this.team.torneiVinti),
                img: this.team.img
            };

            axios.put(`http://localhost:8080/teams/${teamId}`, teamData)
                .then((response) => {
                    console.log("Team aggiornato con successo:", response.data);
                    this.$router.push({
                        path: "/team",
                        query: { message: "Team aggiornato con successo!" }
                    });
                })
                .catch((error) => {
                    console.error("Errore durante l'aggiornamento del team:", error);
                    alert("Errore durante l'aggiornamento del team.");
                });
        },

        resetForm() {
            this.team = {
                nome: "",
                membri: "",
                punteggioTeam: "",
                torneiVinti: "",
                img: ""
            };
        }
    },
};
</script>

<template>
    <main class="tech-arena d-flex align-items-center">
        <div class="dark-circuit"></div>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1 class="neon-title">Modifica Team</h1>
                </div>
                <div class="col-12">
                    <form @submit.prevent="updateTeam">
                        <div class="d-flex flex-wrap">
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="nomeTeam" class="form-label">Nome</label>
                                    <input v-model="team.nome" class="form-control" type="text" id="nomeTeam"
                                        placeholder="Inserisci il nome del tuo team" aria-label="default input example"
                                        required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="membri" class="form-label">Membri</label>
                                    <input v-model="team.membri" class="form-control" type="number" id="membri"
                                        placeholder="Inserisci il numero di membri" aria-label="default input example"
                                        required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="punteggioTeam" class="form-label">Punteggio</label>
                                    <input v-model="team.punteggioTeam" class="form-control" type="number"
                                        id="punteggioTeam" placeholder="Punteggio complessivo del team"
                                        aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="torneiVinti" class="form-label">Tornei vinti</label>
                                    <input v-model="team.torneiVinti" class="form-control" type="number"
                                        id="torneiVinti" placeholder="Numero di tornei vinti"
                                        aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-12 mb-3">
                                <div class="px-2">
                                    <label for="img" class="form-label">Inserisci url foto</label>
                                    <input v-model="team.img" class="form-control" type="text" id="img"
                                        placeholder="Inserisci il link delle foto" aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-12 text-center">
                                <button type="submit" class="back-button">Aggiorna Team</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.container {
    position: relative;
    padding: 30px;
    color: #2bff00;
    z-index: 2;
}

.neon-title {
    font-family: 'Orbitron', sans-serif;
    font-size: 2.8rem;
    color: #2bff00;
    text-shadow: 0 0 10px #2bff00, 0 0 20px #2bff00, 0 0 40px #2bff00;
    margin-bottom: 30px;
    margin-left: 50px;
}

.back-button {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background: #2bff00;
    color: #000000;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
    box-shadow: 0 0 10px #2bff00;
    transition: all 0.3s ease;
}

.back-button:hover {
    background: #ff007a;
    color: white;
    box-shadow: 0 0 15px #ff007a;
}

.tech-arena {
    position: relative;
    background-size: cover;
    background-position: center;
    overflow: hidden;
    height: calc(100vh - 100px);
}

.dark-circuit {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: auto;
    background: linear-gradient(to bottom, rgba(0, 67, 23, 0.8), rgba(0, 0, 0, 0.9));
    z-index: 1;
    opacity: 0.85;
}
</style>