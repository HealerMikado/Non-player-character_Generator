import getConfiguration from "./configuration";

const getApiUrl = async () => {
  const serveurName = await getConfiguration("api");
  console.log(serveurName);
  return serveurName;
}

export default getApiUrl;