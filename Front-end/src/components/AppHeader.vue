<script setup></script>

<template>
  <header>
    <div class="container-fluid">
      <div class="row">
        <div class="col-3">
          <img
            src="https://img.freepik.com/vettori-gratuito/vettore-di-gradiente-del-logo-colorato-uccello_343694-1365.jpg"
          />
        </div>
        <div class="col-6">
          <nav>
            <ol class="d-flex justify-content-around">
              <li><router-link to="/">Robot</router-link></li>
              <li><router-link to="/about">Team</router-link></li>
              <li><router-link to="#">Tornei</router-link></li>
            </ol>
          </nav>
        </div>
        <div class="col-3">
          <img
            src="https://media.tenor.com/1ooa46PKXmYAAAAM/pivot-robot.gif"
            alt=""
          />
        </div>
      </div>
    </div>
  </header>
</template>

<style scoped>
ol {
  list-style: none;
  color: black;
}
a {
  text-decoration: none;
  color: black;
}
img {
  width: 60px;
  height: auto;
}
</style>
