<template>
  <div id="login">
    <div class="loading" v-if="isLoading">
      <img src="@/assets/game_loading.gif" alt="Loading..." />
    </div>
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="successfulRegister" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit" id ="signInButton" :disabled="isLoading">Sign In</button>
      <p><router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      isLoading: false,
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      this.isLoading = true;
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
             setTimeout(() => {
              this.isLoading = false; // Hide loading GIF
              this.$router.push("/");
            }, 100000);
          }
        })
        .catch(error => {
          this.isLoading = false;
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
h1 {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 1rem;
  color: var(--primary800);
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}
.form-input-group {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 1rem;
}
input[type="text"],
input[type="password"],
select {
  width: 110%;
  height: 1rem;
  padding: 0.5rem;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  font-size: 1rem;
  border-radius: 0.25rem;
  border: 1px solid var(--primary800);
  transition-duration: 0.4s;
}
input[type="text"]:focus,
input[type="password"]:focus,
select:focus {
  outline: none;
  border-color: var(--primary400);
  box-shadow: 0 0 0 0.125rem rgba(33, 150, 243, 0.25);
}
label {
  margin-right: 0.5rem;
  text-align: center;
  color: var(--primary800);
  font: bold;
  margin-bottom: 0.75rem;
}
button {
  width: 100%;
  height: 2rem;
  margin-top: 1.5rem;
  border-radius: 0.25rem;
  font-size: 1.2rem;
  background-color: var(--primary400);
  color: var(--primary800);
  border: 3px solid var(--primary800);
  transition-duration: 0.4s;
}
button:hover {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
#login {
  display: flex;
  justify-content: center;
  height: 100vh;
}
form {
  height: fit-content;
}
#signInButton {
  display: flex;
  justify-content: center;
  width: 100%;
  align-items: center;
}
p {
  justify-content: center;
}
.successfulRegister {
  text-align: center;
}
input {
  width: 100%;
}
</style>