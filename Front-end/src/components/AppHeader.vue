<script setup></script>

<template>
  <header class="">
    <div class="container-fluid">
      <div class="row p-3 justify-content-between align-items-center">
        <div class="col-3 ps-5">
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
        <div class="col-3 text-end pe-5">
          <img src="../../public/logo2.png" id="logo" />
        </div>
      </div>
    </div>
  </header>
</template>

<style scoped>

header {
  max-width: 100%;
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
