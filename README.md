<img src="https://img.icons8.com/color/96/java-coffee-cup-logo.png" alt="Ícone do Java" />


<h1 align="center">📊 Calcular Despesas</h1>

<p align="center">
  Aplicativo Java com GUI para registrar, calcular e acompanhar suas despesas mensais.
</p>

---

## 🧩 Funcionalidades

- ✅ Registro de despesas por categoria  
- ✅ Cálculo automático do total e das porcentagens  
- ✅ Colagem rápida de valores com Ctrl + V  
- ✅ Interface intuitiva com tabela e botões  
- ✅ Limpeza rápida dos valores inseridos

---

## 🛠 Tecnologias Utilizadas

- Java (JDK 8+)
- Swing (GUI)
- `DefaultTableModel` (manipulação da tabela)

---

## 💻 Como Funciona o Código

### 🎨 Interface Gráfica (Swing)

A aplicação usa um `JFrame` com um `JTable` e dois botões principais:

- **Calcular Total e Porcentagem**
- **Limpar Valores**

A tabela possui três colunas:
- 📝 **Descrição:** Nome da despesa  
- 💰 **Valor (R$):** Valor gasto  
- 📈 **Porcentagem:** Percentual em relação ao total

---

### 📋 Colagem de Valores (Ctrl + V)

Permite colar valores diretamente da área de transferência na tabela.

**Como funciona:**

- Acessa o conteúdo copiado
- Converte para o formato numérico (ex: `R$ 1.200,00 → 1200.00`)
- Cola diretamente na célula da tabela

---

### ➕ Cálculo de Total e Porcentagens

O botão **"Calcular Total e Porcentagem"**:
- Soma os valores
- Mostra o total na última linha
- Calcula a porcentagem de cada item com base no total

---

### 💡 Formatação Brasileira

Os valores são exibidos no padrão nacional: **R$ 1.200,00**, facilitando a leitura.

---

## 🚀 Como Executar o Projeto

### 📌 Pré-requisitos:
- Java 8 ou superior instalado

### 🔧 Passos:

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/ExpenseTracker.git
cd ExpenseTracker

# 2. Compile o código
javac ExpenseTracker.java

# 3. Execute o programa
java ExpenseTracker
