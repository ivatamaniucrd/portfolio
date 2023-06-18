using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace quizGame
{
    public partial class Form1 : Form
    {

        // variables list for this quiz game
        int correctAnswer;
        int questionNumber = 1;
        int score;
        int percentage;
        int totalQuestions;


        public Form1()
        {
            InitializeComponent();

            askQuestion(questionNumber);

            totalQuestions = 8;



        }

        private void ClickAnswerEvent(object sender, EventArgs e)
        {

            var senderObject = (Button)sender;

            int buttonTag = Convert.ToInt32(senderObject.Tag);




            if (buttonTag == correctAnswer)
            {
                score++;


            }

            if (questionNumber == totalQuestions)
            {
                // finalul cu raspunsurile
                percentage = (int)Math.Round((double)(100 * score) / totalQuestions);


                MessageBox.Show("Quiz-ul sa terminat" + Environment.NewLine +
                                "Ai acumulat " + score + " raspunsuri corecte " + Environment.NewLine +
                                "Procentajul de cunoastere este : " + percentage + " %" + Environment.NewLine +
                                "Incearca inca o data!!!"

                    );

                score = 0;
                questionNumber = 0;

                askQuestion(questionNumber);
            }

            questionNumber++;

            askQuestion(questionNumber);



        }

        private void askQuestion(int qnum)
        {

            

            switch(qnum)
            {

                case 1:

                    pictureBox1.Image = Properties.Resources.carmelita2;
                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Donescu Eugen";
                    button2.Text = "Maia Sandu";
                    button3.Text = "Gatapuc Carmelita";
                    button4.Text = "Marilyn Monroe";

                    correctAnswer = 3;

                    break;
                case 2:
                    pictureBox1.Image = Properties.Resources.valerian;
                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Ceban Dan";
                    button2.Text = "Armasu Constantin";
                    button3.Text = "Soilita Cristian";
                    button4.Text = "Ursu Valerian";


                    correctAnswer = 4;

                    break;

                case 3:

                    pictureBox1.Image = Properties.Resources.mihaela;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Chihai Petru";
                    button2.Text = "Fotescu Mihaela";
                    button3.Text = "Ursu Valerian";
                    button4.Text = "Ivan Turbinca";


                    correctAnswer = 2;

                    break;

                case 4:

                    pictureBox1.Image = Properties.Resources.alexandru;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Tony Montana";
                    button2.Text = "Guzun Darius";
                    button3.Text = "Tomai Daniel";
                    button4.Text = "Melnic Alexandru";


                    correctAnswer = 4;

                    break;

                case 5:

                    pictureBox1.Image = Properties.Resources.daniel;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Lungu Ion";
                    button2.Text = "Tomai Daniel";
                    button3.Text = "Vatamaniuc Ion";
                    button4.Text = "Mike Tyson";

                    correctAnswer = 2;

                    break;

                case 6:

                    pictureBox1.Image = Properties.Resources.sergiu;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Sorocean Sergiu";
                    button2.Text = "Elon Musk";
                    button3.Text = "Bularga Vlad";
                    button4.Text = "Malanca Ion";

                    correctAnswer = 1;

                    break;

                case 7:

                    pictureBox1.Image = Properties.Resources.malanca;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Friptuleac Victor";
                    button2.Text = "Golovatii Maxim";
                    button3.Text = "Malanca Ion";
                    button4.Text = "Mihai Eminescu";

                    correctAnswer = 3;

                    break;

                case 8:

                    pictureBox1.Image = Properties.Resources.vatamaniuc;

                    lblQuestion.Text = "Cine este in imagine?";

                    button1.Text = "Vatamaniuc Ion";
                    button2.Text = "Malanca Ion";
                    button3.Text = "Noroc Ion";
                    button4.Text = "Lungu Ion";

                    correctAnswer = 1;

                    break;




            }




        }

    }
}
