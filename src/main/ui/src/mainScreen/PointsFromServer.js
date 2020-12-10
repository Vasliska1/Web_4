export async function pointCreate(data) {

    const response = await fetch(`/api/addPoint`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return response;
}

export async function getAllPoints() {

    const response = await fetch('/api/getPoints');
    return await response.json();


}