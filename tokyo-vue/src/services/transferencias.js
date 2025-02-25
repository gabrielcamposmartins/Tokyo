import axios from "axios";

const basePath = process.env.VUE_APP_BASE_PATH;

export const getTransferencias = async (params) => {
  try {
    const response = await axios.get(`${basePath}/transferencia/all`, {
      params: params,
    });
    return response.data;
  } catch (error) {
    console.error("Error fetching transferencias:", error);
    throw error;
  }
};

export const createTransferencia = async (transferencia) => {
  try {
    const response = await axios.post(`${basePath}/transferencia`, transferencia);
    return response.data;
  } catch (error) {
    console.error("Error creating transferencia:", error);
    throw error;
  }
}
