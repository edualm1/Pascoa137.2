package unitTest;// Bibliotecas

import br.com.iterasys.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Classe
public class TesteCalculadora {
    // Atributos

    // Funções e Métodos

    @Test
    public void testeSomarDoisNumeros(){
        // Configura
        // Valores de entrada
        double num1 = 7;
        double num2 = 5;
        // Valores de saída
        double resultadoEsperado = 12;

        // Executa
       double resultadoAtual = Calculadora.somarDoisNumeros(num1, num2);

        // Valida
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
public void testeSubtrairDoisNumeros(){
        // Configura
        //Valores de Entrada
        double num1 = 15;
        double num2 = 8;
        // Valores de saída
        double resultadoEsperado = 7;

        // Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(num1, num2);

        // Valida
        assertEquals (resultadoAtual, resultadoEsperado);
    }

    @Test
    public void multiplicarDoisNumeros(){
        // Configura
        // Valores de Entrada
        double num1 = 6;
        double num2 = 3;
        //Valores de saída
        double resultadoEsperado = 18;

        //Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(num1, num2);

        //Valida
        assertEquals(resultadoEsperado, resultadoAtual);
    }
    @Test
    public void dividirDoisNumeros(){
    //Configura
    //Valores de Entrada
    double num1 = 16;
    double num2 = 4;
    //Valores de Saída
    double resultadoEsperado = 4;

    // Executa
    double resultadoAtual = Calculadora.dividirDoisNumerosInteiros(num1, num2);

    // Valida
    assertEquals(resultadoEsperado, resultadoAtual);
    }

    @Test
    public void dividirDoisNumerosNumerosInteiros(){
        // Configura
        // Dados de Entrada
        int numA = 8;
        int numB = 0;
        String resultadoEsperado = "Não é possível dividir por zero";

        // Executa
        String resultadoAtual = Calculadora.dividirDoisNumerosInteiros(numA, numB);

        // Valida
        assertEquals(resultadoEsperado, (resultadoAtual));

    }

    @ParameterizedTest
    @CsvSource(value = {
            "7,5,12.0",
            "56,44,100.0",
            "10, 0, 10.0",
            "15, -5, 10.0",
            "-8, -6, -14.0"
    }, delimiter = ',')
    public void testeSomarDoisNumerosLendoLista(String txtNum1, String txtnum2, String resultadoEsperado){
        // Configura
        // Valores de entrada
        //Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtnum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSomar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarDoisNumerosLendoArquivo(String txtNum1, String txtnum2, String resultadoEsperado){
        // Configura
        // Valores de entrada
        //Os dados de entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.somarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtnum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaSubtrair", numLinesToSkip = 1, delimiter = ',')
    public void testeSubtrairDoisNumerosLendoArquivo(String txtnum1, String txtNum2, String resultadoEsperado){
        //Valores de Entrada
        // Os dados de entrada e o resultado esperado vem da lista

        //Executa
        double resultadoAtual = Calculadora.subtrairDoisNumeros(Integer.valueOf(txtnum1), Integer.valueOf(txtNum2));

        // Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/massaMultiplicar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeMultiplicarDoisNumerosLendoArquivo(String txtNum1, String txtNum2,String resultadoEsperado){
        // Valores de Entrada
        // Os dados de Entrada e o resultado esperado vem da lista

        // Executa
        double resultadoAtual = Calculadora.multiplicarDoisNumeros(Integer.valueOf(txtNum1), Integer.valueOf(txtNum2));

        //Valida
        assertEquals(Double.valueOf(resultadoEsperado), resultadoAtual);}

    }



