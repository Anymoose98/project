<script>
import axios from "axios";
export default {
    data() {
        return {
            teams: [],
            tornei: [],
            robot: {
                nome: "",
                modello: "",
                materiale: "",
                peso: "",
                altezza: "",
                stileDiCombattimento: "",
                velocita: "",
                img: "",
                punteggioRobot: "",
                teamRoboticaId: null,
                torneiIds: []
            }
        };
    },
    mounted() {
        this.chiamatateam();
        this.chiamatatornei();
        this.loadRobotData();
    },
    methods: {
        chiamatateam() {
            axios.get("http://localhost:8080/teams").then((response) => {
                this.teams = response.data;
            });
        },

        chiamatatornei() {
            axios.get("http://localhost:8080/tornei").then((response) => {
                this.tornei = response.data;
            });
        },

        loadRobotData() {
            const robotId = this.$route.params.id;
            axios.get(`http://localhost:8080/robots/${robotId}`)
                .then((response) => {
                    const data = response.data;
                    this.robot = {
                        nome: data.nome,
                        modello: data.modello,
                        materiale: data.materiale,
                        peso: data.peso,
                        altezza: data.altezza,
                        stileDiCombattimento: data.stileDiCombattimento,
                        velocita: data.velocita,
                        img: data.img,
                        punteggioRobot: data.punteggioRobot,
                        teamRoboticaId: data.teamRoboticaId,
                        torneiIds: data.torneiIds || []
                    };
                })
                .catch((error) => {
                    console.error("Errore nel caricamento del robot:", error);
                });
        },

        updateRobot() {
            const robotId = this.$route.params.id;
            const robotData = {
                nome: this.robot.nome,
                modello: this.robot.modello,
                materiale: this.robot.materiale,
                img: this.robot.img,
                peso: parseFloat(this.robot.peso),
                altezza: parseFloat(this.robot.altezza),
                stileDiCombattimento: this.robot.stileDiCombattimento,
                velocita: parseFloat(this.robot.velocita),
                punteggioRobot: parseInt(this.robot.punteggioRobot),
                teamRoboticaId: parseInt(this.robot.teamRoboticaId),
                torneiIds: this.robot.torneiIds.map(id => parseInt(id))
            };

            axios.put(`http://localhost:8080/robots/${robotId}`, robotData)
                .then((response) => {
                    console.log("Robot aggiornato con successo:", response.data);
                    this.$router.push({
                        path: "/robot",
                        query: { message: "Robot aggiornato con successo!" },
                    });
                })
                .catch((error) => {
                    console.error("Errore nell'aggiornamento del robot:", error);
                });
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
                    <h1 class="neon-title">Modifica Robot</h1>
                </div>
                <div class="col-12">
                    <form @submit.prevent="updateRobot">
                        <div class="d-flex flex-wrap">
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="nomeRobot" class="form-label">Nome Robot</label>
                                    <input v-model="robot.nome" class="form-control" type="text" id="nomeRobot"
                                        placeholder="Inserisci il nome del Robot" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="modello" class="form-label">Modello</label>
                                    <input v-model="robot.modello" class="form-control" type="text" id="modello"
                                        placeholder="Inserisci il modello" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="materiale" class="form-label">Materiale</label>
                                    <input v-model="robot.materiale" class="form-control" type="text" id="materiale"
                                        placeholder="Inserisci il materiale" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="peso" class="form-label">Peso</label>
                                    <input v-model="robot.peso" class="form-control" type="number" id="peso"
                                        placeholder="Esprimi il peso in Kg" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="altezza" class="form-label">Altezza</label>
                                    <input v-model="robot.altezza" class="form-control" type="number" id="altezza"
                                        placeholder="Esprimi l'altezza in centimetri" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="stile" class="form-label">Stile di combattimento</label>
                                    <input v-model="robot.stileDiCombattimento" class="form-control" type="text"
                                        id="stile" placeholder="Inserisci lo stile di combattimento" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="velocita" class="form-label">Velocità</label>
                                    <input v-model="robot.velocita" class="form-control" type="number" id="velocita"
                                        placeholder="Inserisci la velocità in Km/h" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="punteggio" class="form-label">Punteggio Robot</label>
                                    <input v-model="robot.punteggioRobot" class="form-control" type="number"
                                        id="punteggio" placeholder="Inserisci il punteggio"
                                        aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-12 mb-3">
                                <div class="px-2">
                                    <label for="img" class="form-label">Inserisci url di una foto</label>
                                    <input v-model="robot.img" class="form-control" type="text"
                                        id="img" placeholder="Inserisci il link di una foto" aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-4">
                                <div class="px-2">
                                    <label for="team" class="form-label">Team robotica</label>
                                    <select v-model="robot.teamRoboticaId" class="form-select" id="team"
                                        aria-label="Default select example" required>
                                        <option value="">Scegli il team</option>
                                        <option v-for="team in teams" :key="team.id" :value="team.id">{{ team.nome }}</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-6 mb-4">
                                <label for="tornei" class="form-label">Tornei</label>
                                <div class="px-2 d-flex flex-wrap justify-content-around">
                                    <div v-for="torneo in tornei" :key="torneo.id" class="form-check col-6">
                                        <input v-model="robot.torneiIds" class="form-check-input" type="checkbox"
                                            :value="torneo.id" :id="torneo.id">
                                        <label class="form-check-label" :for="torneo.id">
                                            {{ torneo.nome }}
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 text-center">
                            <button type="submit" class="back-button">Aggiorna Robot</button>
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
    color: #00ffcc;
    z-index: 2;
}

.neon-title {
    font-family: 'Orbitron', sans-serif;
    font-size: 2.8rem;
    color: #00ffcc;
    text-shadow: 0 0 10px #00ffcc, 0 0 20px #00ffcc, 0 0 40px #00ffcc;
    margin-bottom: 30px;
    margin-left: 50px;
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

.tech-arena {
    position: relative;
    background-size: cover;
    background-position: center;
    overflow: hidden;
    min-height: 100vh;
}

.dark-circuit {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: linear-gradient(to bottom, rgba(10, 25, 47, 0.8), rgba(0, 0, 0, 0.9));
    z-index: 1;
    opacity: 0.85;
}
</style>