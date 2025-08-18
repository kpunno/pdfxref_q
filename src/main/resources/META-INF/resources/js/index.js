
document.getElementById("upload").onchange = async (e) => {
    file = e.target.files[0];
    const formData = new FormData();
    formData.append('file', file);

    res = await fetch("/upload", {
        method: "POST",
        body: formData
    });
}