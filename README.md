<p align="center">
  <img src="https://i.postimg.cc/y8zmykw8/logo.jpg" alt="Logo" width="300">
</p>

# 📝 Descrição

Este repositório contém o projeto desenvolvido como parte da **Situação de Aprendizagem** do **CentroWeg - MIDS 78**. O objetivo foi demonstrar os conhecimentos adquiridos na disciplina de:

- **Técnicas de Programação**

Além disso, foram aplicados conhecimentos complementares em áreas como **Programação Orientada a Objetos (POO)**, **Java com Maven**.

## 🎯 Objetivo

O ProjetoRH é um sistema, projetado para:
- Cadastrar funcionários
- Cadastrar cursos
- Atribuir cursos a funcionários

```
# 📂 Estrutura do Projeto

📁 ProjetoRH
├── README.md
├── pom.xml
├── 📁 src
│   └── 📁 main
│       ├── 📁 java
│       │   ├── Main.java
│       │   ├── 📁 application
│       │   │   ├── 📁 controller
│       │   │   │   ├── CursoController.java
│       │   │   │   ├── FuncionarioController.java
│       │   │   │   ├── InscricaoController.java
│       │   │   │   ├── SessaoController.java
│       │   │   │   └── UsuarioController.java
│       │   │   ├── 📁 dto
│       │   │   │   ├── 📁 cargo
│       │   │   │   │   └── CadastrarCargoRequest.java
│       │   │   │   ├── 📁 curso
│       │   │   │   │   ├── AtualizarStatusCursoRequest.java
│       │   │   │   │   ├── AtualizarStatusCursoResponse.java
│       │   │   │   │   ├── CadastrarCursoRequest.java
│       │   │   │   │   ├── CadastrarCursoResponse.java
│       │   │   │   │   ├── CursoDetalheDTO.java
│       │   │   │   │   ├── CursoStatusDTO.java
│       │   │   │   │   ├── DetalheCursoResponse.java
│       │   │   │   │   ├── EditarStatusCursoRequest.java
│       │   │   │   │   ├── EditarStatusCursoResponse.java
│       │   │   │   │   ├── ExcluirCursoRequest.java
│       │   │   │   │   ├── ExcluirCursoResponse.java
│       │   │   │   │   ├── ListarCursoRequest.java
│       │   │   │   │   ├── ListarCursoResponse.java
│       │   │   │   │   ├── ListarMeusCursosResponse.java
│       │   │   │   │   └── ListarTodosCursoResponse.java
│       │   │   │   ├── 📁 funcionario
│       │   │   │   │   ├── CadastrarFuncionarioExcelRequest.java
│       │   │   │   │   ├── CadastrarFuncionarioRequest.java
│       │   │   │   │   ├── CadastrarFuncionarioResponse.java
│       │   │   │   │   ├── ExcluirFuncionarioRequest.java
│       │   │   │   │   ├── ExcluirFuncionariosResponse.java
│       │   │   │   │   ├── FuncionarioControllerRequest.java
│       │   │   │   │   └── ListarTodosFuncionarioResponse.java
│       │   │   │   ├── 📁 inscricao
│       │   │   │   │   ├── AtribuirCursoCargoRequest.java
│       │   │   │   │   ├── AtribuirCursoCargoResponse.java
│       │   │   │   │   ├── AtribuirCursoFuncionarioRequest.java
│       │   │   │   │   └── AtribuirCursoFuncionarioResponse.java
│       │   │   │   └── 📁 usuario
│       │   │   │       ├── CadastrarUsuarioRequest.java
│       │   │   │       └── LoginUsuarioRequest.java
│       │   │   ├── 📁 factory
│       │   │   │   └── AppFactory.java
│       │   │   ├── 📁 mapper
│       │   │   │   ├── CursoMapper.java
│       │   │   │   ├── FuncionarioMapper.java
│       │   │   │   ├── SessaoMapper.java
│       │   │   │   └── UsuarioMapper.java
│       │   │   ├── 📁 service
│       │   │   │   ├── CargoService.java
│       │   │   │   ├── CursoService.java
│       │   │   │   ├── FuncionarioService.java
│       │   │   │   ├── InscricaoService.java
│       │   │   │   ├── SessaoService.java
│       │   │   │   └── UsuarioService.java
│       │   │   └── 📁 sessao
│       │   │       └── SessaoSistema.java
│       │   ├── 📁 domain
│       │   │   ├── 📁 model
│       │   │   │   ├── Curso.java
│       │   │   │   ├── Funcionario.java
│       │   │   │   ├── Sessao.java
│       │   │   │   ├── Usuario.java
│       │   │   │   ├── 📁 enums
│       │   │   │   │   ├── StatusCurso.java
│       │   │   │   │   ├── StatusCursoPessoal.java
│       │   │   │   │   └── TipoUsuario.java
│       │   │   │   └── 📁 valueobjects
│       │   │   │       ├── Email.java
│       │   │   │       └── Telefone.java
│       │   │   └── 📁 repository
│       │   │       ├── CargoRepository.java
│       │   │       ├── CursoRepository.java
│       │   │       ├── FuncionarioRepository.java
│       │   │       ├── InscricaoRepository.java
│       │   │       ├── SessaoRepository.java
│       │   │       └── UsuarioRepository.java
│       │   ├── 📁 infrastructure
│       │   │   ├── 📁 database
│       │   │   │   └── ConexaoFactory.java
│       │   │   └── 📁 persistence
│       │   │       ├── CargoRepositoryImpl.java
│       │   │       ├── CursoReposityImpl.java
│       │   │       ├── FuncionarioRepositoryImpl.java
│       │   │       ├── InscricaoRepositoryImpl.java
│       │   │       ├── SessaoRepositoryImpl.java
│       │   │       └── UsuarioRepositoryImpl.java
│       │   └── 📁 view
│       │       ├── GerenciarCursosView.java
│       │       ├── MenuPrincipalView.java
│       │       ├── MenuRHView.java
│       │       ├── MenuTreinamentosView.java
│       │       └── MenuUsuarioView.java
│       └── 📁 resources
│           └── application.properties
└── target/


```

# 🛠️ Tecnologias Utilizadas

<div align="left">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" />  
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/apache/apache-original.svg" height="40" />  
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" />  
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="40" />  
</div>

- [**Java 21**](https://www.oracle.com/java/) — Desenvolvimento do backend  
- [**Maven 4.0.0**](https://maven.apache.org/) — Build e gerenciamento de dependências  
- [**MySQL**](https://www.mysql.com/) — Banco de dados utilizado  
- [**Git**](https://git-scm.com/) — Versionamento e colaboração  

---

# 📱 Versão Atual

A versão atual do sistema contempla:
- Desenvolvendo

> **📌 Nota:** A versão atual entrega o funcionamento...

---

# ▶️ Como Executar

## ✅ Pré-requisitos
- Java blablabla

## ⚙️ Passos para Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/TrabalhoFinalMIDS78/WEGONE_V1_BACK.git
   cd WEGONE_V1_BACK
   
Configure o terminal para UTF-8 (Windows)


>💡 Atenção: Configure corretamente a conexão com o banco de dados no código antes da execução.


### 👨‍💻 Equipe

- [**Bruno Luis**](https://github.com/) — *Product Owner* e Dev (lógica e estrutura base)  
- [**Matheus Engel**](https://github.com/) — Dev (conexão e estrutura do banco de dados)  
- [**Leticia Guths**](https://github.com/) — Dev (lógica e testes)  
- [**Gustavo Kotryk**](https://github.com/GustavoKotryk) — *Scrum Master* e Dev (organização, versionamento, integração)

---

## 📚 Agradecimentos

Agradecemos aos professores que apoiaram e orientaram o desenvolvimento deste projeto:

- Bruno da Silva Andrade  
- Vinicius Matheus Jacobowski Trindade  

---

## 💡 Observação Final

O **ProjetoRH** representa nossa evolução como desenvolvedores e o resultado de um trabalho conjunto, aplicando boas práticas. O projeto está pronto para crescer com novas funcionalidades e melhorias de integração.

 
 
