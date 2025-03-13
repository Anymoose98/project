<script></script>
<template>
    <main>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1 class="neon-title">Aggiungi un robot</h1>
                </div>
                <div class="col-12 ">
                    <form>
                        <div class="d-flex flex-wrap">
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Nome Robot</label>
                                    <input class="form-control " type="text" placeholder="A me a cocaina"
                                        aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Modello</label>
                                    <input class="form-control " type="text" placeholder="Mee mee trasformava"
                                        aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Materiale</label>
                                    <input class="form-control " type="text" placeholder="Io nasco "
                                        aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Peso</label>
                                    <input class="form-control " type="text" placeholder="Come un violento"
                                        aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Altezza</label>
                                    <input class="form-control " type="text" placeholder="Come un violento"
                                        aria-label="default input example">
                                </div>
                            </div>
                            <div class="col-6 mb-3">
                                <div class="px-2">
                                    <label for="exampleInputPassword1" class="form-label">Stile di combattimento</label>
                                    <input class="form-control " type="text" placeholder="Come un violento"
                                        aria-label="default input example">
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.container {
    padding: 30px;
    color: #00ffcc
}

.neon-title {
    font-family: 'Orbitron', sans-serif;
    font-size: 2.8rem;
    color: #00ffcc;
    text-shadow: 0 0 10px #00ffcc, 0 0 20px #00ffcc, 0 0 40px #00ffcc;
    margin-bottom: 30px;
    margin-left: 50px;
}
</style>