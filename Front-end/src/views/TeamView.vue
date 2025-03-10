<template>
  <div class="container">
    <div class="row">
  <div class="col-md-4">
    <div class="card shadow-sm team-card">
      <img src="../../public/slide-2.png" class="card-img-top team-image" alt="Foto Team">
      <div class="card-body">
        <h5 class="card-title">nome team</h5>
        <p class="card-text"><strong>Membri:</strong> numero dei membri</p>
        <p class="card-text"><strong>Partecipazioni:</strong> 6</p>
        <p class="card-text"><strong>Tornei vinti:</strong> 7</p>
      </div>
    </div>
  </div>
</div>
  </div>
</template>

<style scoped>
.team-card {
  border-radius: 12px;
  overflow: hidden;
  transition: transform 0.3s ease-in-out;
}

.team-card:hover {
  transform: scale(1.05);
}

.team-image {
  height: 200px;
  object-fit: cover;
}

</style>
