import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://192.168.56.102:8080',
  headers: { 'Access-Control-Allow-Methods': 'GET',
    'Access-Control-Allow-Origin': '*:*' }
})
export default instance
