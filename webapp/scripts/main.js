$(document).ready(function () {

    function shiftCipher(int, text, i) {

        let output;
        $('#editor').text(text);
        setTimeout(function() {

            if(i === text.length) {
                return
            }
            else {
                if(text[i] === " ") {
                    shiftCipher(int, text, i+1);
                }
                else {
                    output = text.substr(0, i) + String.fromCharCode(text.charCodeAt(i) + int) + text.substr(i+1, text.length);
                    $('#editor').text(output);
                    shiftCipher(int, output, i + 1);
                }
            }
        }, 50)
    }

    function shiftDeCipher(int, text, i) {
        let output;
        $('#editor').text(text);
        setTimeout(function () {
            if(i === text.length) {
                return
            }
            else {
                if(text[i] === " ") {
                    shiftDeCipher(int, text, i+1);
                }
                else {
                    output = text.substr(0, i) + String.fromCharCode(text.charCodeAt(i) - int) + text.substr(i+1, text.length);
                    $('#editor').text(output);
                    shiftDeCipher(int, output, i+1);
                }
            }
        }, 50)
    }
    

    $('#encrypt').on('click', function() {
        var input;
        input = $('#this')[0].value
        console.log(input)
        shiftCipher(3,input, 0);
    })
    $('#decrypt').on('click', function() {
        var input;
        input = $('#this')[0].value
        console.log(input)
        shiftDeCipher(3,input, 0);
    })
    $('#transfer').on('click', function() {
        $('#this')[0].value = $('#editor').text();
    })
})