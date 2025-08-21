
document.getElementById("upload").onchange = async (e) => {
    file = e.target.files[0];
    req = { 
        method: "POST", 
        body: {"file":file}
    };
    res = await fetch("/upload", req);
    console.log(res)
}