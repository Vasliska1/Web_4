export async function pointCreate(data) {

    const response = await fetch(`/api/point`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json',
            Authorization: "Bearer " + localStorage.getItem("auth")},
        body: JSON.stringify(data)
    })
    return response;
}

export async function getAllPoints() {

    const response = await fetch('/api/point',
        {
            method: 'GET',
            headers: {
                Authorization: "Bearer " + localStorage.getItem("auth")
            }
        });
    return await response.json();

}


export async function check() {

    const response = await fetch('/api/check',
        {
            method: 'GET',
            headers: {
                Authorization: "Bearer " + localStorage.getItem("auth")
            }
        });


    console.log(response + "resp")
    return  response;



}