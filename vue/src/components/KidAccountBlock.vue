<template>
  <div>
    <button v-on:click="addKid">Add Kid</button>
      <div class="kid-block">
        <ul>
          <li v-for="kid in kids" v-bind:key="kid.id">
              <h2>{{ kid.name }}</h2>
              <div class="kid-details">
                <p>Steps: {{ kid.steps }}</p>
                <p>Hours of Activity: {{ kid.hours }}</p>
                <p>Carrots: {{ kid.carrots }}</p>
              </div>
              <div class="buttons">
                <button v-on:click="showForm(kid.id)">Log Hours/Steps</button>
                <button>View Account</button>
                <button v-on:click="deleteKid(kid.id)">Remove Kid</button>
              </div>
          </li>
        </ul>
        <form v-on:submit.prevent="updateKidActivity" class="log-hours-form"  v-if="isFormShown">
          <label for="steps">Steps: </label>
          <input type="number" id="steps" v-model="activityForm.steps">
          <label for="hours">Hours: </label>
          <input type="number" id="hours" v-model="activityForm.hours">
          <input type="submit">
          <button v-on:click="hideForm">Cancel</button>
        </form>
      </div>
  </div>
</template>

<script>

export default {
  data() {
    return {
      // newKid: {
      //   name: "jean",
      //   steps: 1
      // },
      activityForm: {
        steps: 0,
        hours: 0
      },
      currentKidId: 0,
      kids: this.$store.state.kids
    }
  },
  methods: {
    addKid() {
      this.$router.push('/parents/register')
      // KidService.createKid(this.$store.state.user.id, this.newKid).then(

      // )

    },
    showForm(kidId) {
      this.currentKidId = kidId;
    },
    hideForm() {
      this.currentKidId = 0;
    },
    updateKidActivity() {
      let newKid = this.kids[this.currentKidId-1]
      newKid.steps = this.activityForm.steps;
      newKid.hours = this.activityForm.hours;
      //this.$store.commit('UPDATE_ACTIVITY', newKid, this.activityForm)
      this.hideForm();
    },
    deleteKid(kidId) {
      let currentKid = this.kids.find( kid => {
        return kid.id === kidId;
      });
      if(confirm(`Are you sure you want to delete ${currentKid.name}`)) {
        this.$store.commit('DELETE_KID',currentKid)
      }
    }
  },
  computed: {
    isFormShown() {
      return this.currentKidId > 0;
    }
  }
}

</script>

<style>
.kid-block {
  display: flex;
  justify-content: center;
  align-items: center;
}
  button {
    background-color: #47d7ac;
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 18px;
    color: white;
    font-weight: bold;
    transition-duration: 0.4s;
  }
  button:hover {
    background-color: var(--primary800);
    border: 3px solid var(--primary400);
    color: white;
  }
  input[type="submit"] {
    background-color: #47d7ac;
    border: 2px solid;
    border-color: #1dc5ba;
    padding: 10px 20px;
    font-size: 18px;
    color: white;
    font-weight: bold;
  }
  li {
    display: flex;
    margin: 40px
  }
  li > h2 {
    margin-right: 20px
  }
  .kid-details {
    display: flex;
  }
  .kid-details > p {
    margin-right: 20px;
  }
  .buttons > button {
    margin-right: 20px;
  }
  form > * {
    margin-right: 20px
  }
</style>