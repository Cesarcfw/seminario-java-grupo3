# Como executar o projeto no dia do seminário

Este guia foi feito para apresentar o projeto **sem baixar os arquivos no computador da faculdade**. O computador precisa de navegador, internet e acesso à conta do GitHub que pode abrir o repositório.

Repositório: <https://github.com/Cesarcfw/seminario-java-grupo3>

## Opção principal: GitHub Codespaces

O Codespaces abre um ambiente de desenvolvimento no navegador, com terminal. O projeto configura esse ambiente com Java 21 em `.devcontainer/devcontainer.json`. O primeiro início pode levar alguns minutos; por isso, faça o teste antes do dia da apresentação.

1. Entre no GitHub com a conta que tem acesso ao repositório.
2. Abra o link do repositório acima e confira que a branch selecionada é `main`.
3. Clique em **Code > Codespaces**. Se já existir um ambiente, abra-o. Caso contrário, clique em **Create codespace on main**.
4. Quando o VS Code no navegador abrir, escolha **Terminal > New Terminal**. O terminal deve começar na raiz do projeto; confira se aparecem `README.md` e a pasta `src`.
5. Confira a versão do Java:

   ```bash
   java -version
   javac -version
   ```

   A configuração do projeto prepara Java 21. Se aparecer outra versão, pare e confira se o Codespace foi criado depois que `.devcontainer/devcontainer.json` chegou ao GitHub.

6. Compile o programa e os testes:

   ```bash
   javac -d out src/main/java/br/com/grupo3/seguros/*.java src/test/java/br/com/grupo3/seguros/*.java
   ```

7. Execute a demonstração:

   ```bash
   java -cp out br.com.grupo3.seguros.Main
   ```

   A última linha esperada é `Total dos seguros: R$ 20.670,00`. O espaço entre `R$` e o número pode variar conforme a formatação do terminal.

8. Execute os testes:

   ```bash
   java -cp out br.com.grupo3.seguros.TesteVeiculos
   ```

   A mensagem esperada é `Todos os testes passaram.`

**Dica para a apresentação:** deixe o Codespace aberto no navegador antes de começar. O integrante responsável pela demonstração pode executar somente os comandos dos passos 7 e 8 se o passo 6 já tiver sido feito no ensaio. Como a compilação gera a pasta `out` dentro do Codespace, ela precisa ser refeita se o ambiente for recriado.

## Opção de reserva: GitHub Actions pelo navegador

Se o Codespace não abrir, o fluxo `Verificacao Java` pode ser iniciado manualmente no GitHub depois que a atualização deste projeto estiver na branch `main`:

1. No repositório, abra **Actions > Verificacao Java**.
2. Clique em **Run workflow**, selecione `main` e confirme em **Run workflow**.
3. Abra a execução nova e o trabalho **compilar-e-testar**.
4. Expanda **Executar os testes** para mostrar a mensagem de sucesso.
5. Expanda **Executar a demonstracao** para mostrar os quatro veículos e o total.

Esta opção mostra a saída nos registros do GitHub. Ela pode demorar para entrar na fila e não oferece um terminal interativo durante a apresentação. Se o botão **Run workflow** não aparecer, confira se você está conectado a uma conta com permissão para executar o fluxo e se o arquivo da automação já foi enviado para `main`.

## Antes de sair para a faculdade

- Confirme que o repositório abre na conta que será usada no dia.
- Crie ou retome um Codespace e execute os passos 5 a 8 pelo menos uma vez.
- Confira uma execução verde em **Actions** e teste o botão **Run workflow**.
- Abra os slides no mesmo computador ou em um computador com projeção semelhante.
- Se a internet da sala for instável, leve uma cópia do projeto e dos slides como reserva. Para executar localmente, o computador precisará de JDK 21; os comandos estão no `README.md`.

## Referências

- [Criar um Codespace para um repositório](https://docs.github.com/en/codespaces/developing-in-a-codespace/creating-a-codespace-for-a-repository), GitHub Docs.
- [Abrir um Codespace existente](https://docs.github.com/en/codespaces/developing-in-a-codespace/opening-an-existing-codespace), GitHub Docs.
- [Executar um workflow manualmente](https://docs.github.com/en/actions/how-tos/manage-workflow-runs), GitHub Docs.
- [Consultar os registros de um workflow](https://docs.github.com/en/actions/how-tos/monitor-workflows/use-workflow-run-logs), GitHub Docs.
