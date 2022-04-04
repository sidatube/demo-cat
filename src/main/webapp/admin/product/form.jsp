
<!DOCTYPE html>
<html>
<title>Create Student</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-blue">
    <h2>Input Form</h2>
</div>

<form class="w3-container" action="/products/create" method="post">
    <p>
        <label>Name </label>
        <input class="w3-input" name="name" type="text"></p>
    <p>
        <label>Thumbnail </label>
        <input class="w3-input" name="thumbnail"  type="text"></p>
    <p>
        <label>Price</label>
        <input class="w3-input" name="price"  type="number"></p>
    <p>
        <button class="w3-btn w3-blue">
            Create
           </button>
    <button type="reset" class="w3-btn w3-khaki">Reset</button></p>
</form>

</body>
</html>
