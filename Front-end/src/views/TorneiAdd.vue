<script>
import axios from "axios";
export default {
    data() {
        return {
            torneo: {
                nome: "",
                dataInizio: "",
                dataFine: "",
                geografica: "",
                img:""
            }
        };
    },
    mounted() {
        // Vuoto se non ci sono chiamate iniziali
    },
    methods: {
        submitTorneo() {
            const torneoData = {
                nome: this.torneo.nome,
                dataInizio: this.torneo.dataInizio, // Stringa nel formato atteso dal backend (es. ISO 8601)
                dataFine: this.torneo.dataFine,     // Stringa nel formato atteso dal backend (es. ISO 8601)
                geografica: this.torneo.geografica,  // Stringa per la posizione geografica
                img: this.torneo.img
            };

            axios.post("http://localhost:8080/tornei", torneoData)
                .then((response) => {
                    console.log("Torneo aggiunto con successo:", response.data);
                    // Redirect a /tornei con un messaggio di successo
                    this.$router.push({
                        path: "/tornei",
                        query: { message: "Torneo aggiunto con successo!" }
                    });
                    // Resetta il form dopo il successo
                    this.resetForm();
                })

        },
        resetForm() {
            this.torneo = {
                nome: "",
                dataInizio: "",
                dataFine: "",
                geografica: "",
                img:""
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
                    <h1 class="neon-title">Aggiungi un torneo</h1>
                </div>
                <div class="col-12">
                    <form @submit.prevent="submitTorneo">
                        <div class="d-flex flex-wrap">
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="nomeTorneo" class="form-label">Nome</label>
                                    <input v-model="torneo.nome" class="form-control" type="text" id="nomeTorneo"
                                        placeholder="Inserisci il nome del torneo" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="geografica" class="form-label">Posizione Geografica</label>
                                    <input v-model="torneo.geografica" class="form-control" type="text" id="geografica"
                                        placeholder="Inserisci la posizione geografica" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="dataInizio" class="form-label">Data Inizio</label>
                                    <input v-model="torneo.dataInizio" class="form-control" type="date" id="dataInizio"
                                        placeholder="Inserisci la data di inizio" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="dataFine" class="form-label">Data Fine</label>
                                    <input v-model="torneo.dataFine" class="form-control" type="date" id="dataFine"
                                        placeholder="Inserisci la data di fine" aria-label="default input example" required>
                                </div>
                            </div>
                            <div class="col-12 mb-3">
                                <div class="px-2">
                                    <label for="img" class="form-label">Inserisci url foto</label>
                                    <input v-model="torneo.img" class="form-control" type="text" id="nomeTorneo"
                                        placeholder="Inserisci il link della foto" aria-label="default input example" 
                                </div>
                            </div>
    
                        </div>
                        <div class="col-12 text-center">
                            <button type="submit" class="back-button">Submit</button>
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
    color: #ff0000;
    z-index: 2;
}

.neon-title {
    font-family: 'Orbitron', sans-serif;
    font-size: 2.8rem;
    color: #ff0000;
    text-shadow: 0 0 10px #ff0000, 0 0 20px #ff0000, 0 0 40px #ff0000;
    margin-bottom: 30px;
    margin-left: 50px;

}

.back-button {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background: #ff0000;
    color: #000000;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
    box-shadow: 0 0 10px #ff0000;
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
    height: 100%;
    background: linear-gradient(to bottom, rgba(39, 0, 0, 0.805), rgba(0, 0, 0, 0.9));
    z-index: 1;
    opacity: 0.85;
}
</style>