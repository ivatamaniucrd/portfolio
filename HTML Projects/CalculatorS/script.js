
    document.getElementById('calculeaza').addEventListener('click', function() {
      var sumaDepusa = parseFloat(document.getElementById('suma-depusa').value);
      var termen = parseInt(document.getElementById('termen').value);
      var rataDobanzii = parseFloat(document.getElementById('rata-dobanzii').value);
      var plataDobanzii = document.getElementById('plata-dobanzii').value;
      var reinnoire = parseInt(document.getElementById('reinnoire').value);

      var periodaZile = termen * 30;
      var dobandaBruta = (sumaDepusa * periodaZile * rataDobanzii) / (360 * 100);
      var impozit = 0.1 * dobandaBruta;
      var dobandaNeta = dobandaBruta - impozit;

      if (plataDobanzii === 'lunar') {
        dobandaNeta /= termen;
      }

      var sumaFinala = sumaDepusa + dobandaNeta;
      document.getElementById('suma-depusa-afisata').textContent = 'Suma depusă: ' + sumaDepusa.toFixed(2);
document.getElementById('termen-afisat').textContent = 'Termen: ' + termen + ' luni';
document.getElementById('rata-dobanzii-afisata').textContent = 'Rata dobânzii: ' + rataDobanzii + '%';
document.getElementById('plata-dobanzii-afisata').textContent = 'Plata dobânzii: ' + (plataDobanzii === 'lunar' ? 'Lunar' : 'Anual');
document.getElementById('reinnoire-afisata').textContent = 'Reînnoire depozit: ' + (reinnoire === 0 ? 'Fără reînnoire' : reinnoire + ' ori');
document.getElementById('suma-finala-afisata').textContent = 'Suma finală acumulată: ' + sumaFinala.toFixed(2);

      alert('Suma finală acumulată la scadența depozitului este: ' + sumaFinala.toFixed(2));
    });
