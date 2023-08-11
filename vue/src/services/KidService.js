import axios from 'axios';

// TODO: Retrieve kids from parents

export default {
    getParents() { 
        return axios.get('/users')
    },
    getKids(parentID) { 
        return axios.get(`/users/${parentID}`)
    },
    getKid(parentID, kidID) { 
        return axios.get(`/users/${parentID}`).then((response) => {
            const kids = response.data.kids;
            return kids.find(kid => kid.id == kidID);
        })
    },
    createKid(kid) {
        return axios.post(`/kids`,kid);
    },
    deleteKid(kidID) {
        return axios.delete(`/kids/${kidID}`)
    },
    getActivity(kidID) {
        return axios.get(`/activity/${kidID}/`)
    },
    getActivities(parentID) {
        return axios.get(`activities/${parentID}`)
    },
    updateActivity(activity) {
        return axios.put(`/activity/update/${activity.kidId}`, activity)
    }
}