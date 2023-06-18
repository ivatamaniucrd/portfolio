function solveEquation() {
  // Get the values of the input fields
  const a = parseFloat(document.getElementById("a").value);
  const b = parseFloat(document.getElementById("b").value);
  const c = parseFloat(document.getElementById("c").value);

  // Calculate the discriminant
  const discriminant = Math.pow(b, 2) - 4 * a * c;

  // Calculate the solutions
  let solution = "";

  if (a === 0) {
    solution = "This is not a quadratic equation.";
  } else if (discriminant < 0) {
    solution = "There are no real solutions.";
  } else if (discriminant === 0) {
    const x = -b / (2 * a);
    solution = `There is one solution: x = ${x}.`;
  } else {
    const x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
    const x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
    solution = `There are two solutions: x1 = ${x1}, x2 = ${x2}.`;
  }

  // Display the solution
  document.getElementById("solution").innerHTML = solution;
}
