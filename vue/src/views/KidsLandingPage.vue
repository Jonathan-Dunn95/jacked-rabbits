<template>
  <div>
      <h1>Kids Landing Page</h1>
      <button v-on:click="addKid">add kids</button>
      <ul>
          <!-- Loop through kids in DB -->
          <li>
              <h2>child_name</h2>
          </li>
      </ul>
  </div>
</template>

<script>
export default {
    name: "kids-landing-page",
    methods: {
        addKid() {
            console.log("adding kid")
        }
    }

}
</script>

<style>

</style>