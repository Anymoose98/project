<script setup></script>

<template>
  <footer class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-12 mb-5 text-center">
          <h1 class="text-warning">Seguici sui nostri social</h1>
        </div>
        <div class="col-12 d-flex justify-content-around">
          <div class="facebook social text-center">
            <img src="../../public/facebook.png" alt="" />
            <h3 class="mt-2 facebook">Facebook</h3>
          </div>
          <div class="instagram social text-center">
            <img src="../../public/instagram.png" alt="" />
            <h3 class="mt-2">Instagram</h3>
          </div>
          <div class="youtube social text-center">
            <img src="../../public/youtube.png" alt="" />
            <h3 class="mt-2">Youtube</h3>
          </div>
        </div>
      </div>
    </div>
    <hr />
    <div class="container">
      <div class="row">
        <div class="col-4">
          <div class="">
            <h3 class="mx-2 text-warning">Contatti</h3>
            <div>
              <div class="mt-2 d-flex align-items-center">
                <i class="fa-solid fa-map-location-dot mx-3 text-warning"></i>
                <div>Via Dei Cerchi 36, Roma</div>
              </div>
              <div class="mt-2 d-flex align-items-center">
                <i class="fa-brands fa-instagram mx-3 text-warning"></i>
                <div><a href="#">@Steel_Fight</a></div>
              </div>
              <div class="mt-2 d-flex align-items-center">
                <i class="fa-brands fa-whatsapp mx-3 text-warning"></i>
                <div>
                  <a
                    href="https://wa.me/393408409931&text=Ciao%2C%20sono%20interessato%20vorrei%20avere%20più%20informazioni%20sul%20prossimo%20evento"
                    target="_blank"
                    >+39 3408409931</a
                  >
                </div>
              </div>
            </div>
          </div>
          <div class="mt-2">

            L'azienda Steel Fight è regolamentata <br>ufficialmente da FIFA<br />P.IVA
            57812314867
          </div>
        </div>
        <div class="col-8">
          <h3 class="text-warning text-center">Orari</h3>
          <div class="d-flex justify-content-around mt-5">
            <div>
              <h5>Lunedì</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Martedì</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Mercoledì</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Giovedì</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Venerdì</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Sabato</h5>
              <p>9:00 - 18:00</p>
            </div>
            <div>
              <h5>Domenica</h5>
              <p>Chiuso</p>
            </div>
          </div>
        </div>
        <div class="col-12 text-end">
          <p class="mt-2">
            &copy; 2025 Steel Fight. Tutti i diritti riservati.
          </p>
        </div>
      </div>
    </div>
  </footer>
</template>
<style scoped>
a {
  color: white;
}
hr {
  border: 3px solid white;
}
img {
  width: 20%;
  height: auto;
}
.social {
  filter: grayscale(100%);
}
.social:hover {
  filter: grayscale(0%);
}
.social:hover h5 {
  color: blue;
}
footer {
  background-color: black;
  color: white;
}
h1 {
  margin: 0;
}
</style>
