<script setup></script>

<template>
  <header class="">
    <div class="container-fluid">
      <div class="row p-3 justify-content-between align-items-center">
        <div class="col-3">
          <img src="../../public/logo2.png" id="logo" />
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
        <div class="col-3 text-end">
          <img src="../../public/logo2.png" id="logo" />
        </div>
      </div>
    </div>
  </header>
  <div class="sfondo">
    <div class="img-container">
      <img src="../../public/robot4.webp" id="gif" alt="non funziona" />
    </div>
  </div>
</template>

<style scoped>
.img-container {
  height: calc(100vh - 100px);
}
.sfondo {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 1) 0%,
    rgba(0, 0, 0, 1) 100%
  );
}
#gif {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
header {
  height: 100px;
  background-color: #282c2f;
  color: white;
 
}
#logo {
  width: 150px;
  height: auto;
  transition: trasform 1s ease;
  display: inline-block;
}
#logo:hover {
  transform: scale(1.5);
  
}
ol {
  list-style: none;
  color: black;
}
a {
  text-decoration: none;
  color: white;
  font-size: 25px;
  font-weight: bold;
  transition: trasform 1s ease;
  display: inline-block;
}
a:hover {
  color: #e9e6dc;
  transform: scale(1.5);
}
img {
  width: 60px;
  height: auto;
}
</style>
