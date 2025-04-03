# calcular-dispesas
 Aplicação para Controle de Despesas  Descrição É um aplicativo Java com interface gráfica (GUI) desenvolvida com Swing. Ele permite que o usuário registre e acompanhe despesas mensais, calculando automaticamente o total gasto e a porcentagem de cada despesa em relação ao total. A aplicação suporta a colagem de valores diretamente da área de transferência (Ctrl + V) e fornece botões para calcular valores e limpar os campos.
Funcionalidades
 Registro de despesas: O usuário pode inserir valores para cada categoria de despesa.
Cálculo automático: O total gasto e a porcentagem de cada despesa são calculados automaticamente.
Colagem de valores: Permite colar valores diretamente da área de transferência (Ctrl + V).
 Interface intuitiva: Desenvolvida com Swing, possui uma tabela e botões de fácil uso.
 Limpeza de valores: Botão para limpar todos os valores inseridos.

 Tecnologias Utilizadas
    • Java (JDK 8+)
    • Swing (GUI)
    • DefaultTableModel (Manipulação da tabela de despesas)

 Como Funciona o Código?
Interface Gráfica (Swing)
O código cria um JFrame (Janela Principal) com um JTable (Tabela de Despesas) e dois botões:
    • Calcular Total e Porcentagem
    • Limpar Valores
A tabela possui três colunas:
Descrição (Nome da despesa)
Valor (R$) (Valor gasto)
Porcentagem (Quanto representa do total)
Colagem de Valores (Ctrl + V)
O código permite copiar e colar valores diretamente na tabela usando o atalho Ctrl + V.
 Como funciona?
    • O código acessa a área de transferência (Clipboard)
    • Pega os valores copiados
    • Converte para o formato correto (R$ 1.200,00 → 1200.00)
    • Cola na tabela
Cálculo do Total e Porcentagens
O botão "Calcular Total e Porcentagem" soma os valores e exibe o total na última linha da tabela.
Além disso, calcula a porcentagem de cada despesa em relação ao total.
 Formatação Correta dos Valores
Os valores são exibidos no formato brasileiro (R$ 1.200,00) para melhor visualização.
Como Executar o Projeto?
Pré-requisitos:
    • Java 8+ instalado no computador
Passos:
1️- Baixe o código ou clone o repositório:
git clone https://github.com/seu-usuario/ExpenseTracker.git
cd ExpenseTracker
2️- Compile o código:
javac ExpenseTracker.java
3️- Execute o programa:
java ExpenseTracker

 Licença
Este projeto é de código aberto e pode ser utilizado livremente.
Sinta-se à vontade para contribuir! 
