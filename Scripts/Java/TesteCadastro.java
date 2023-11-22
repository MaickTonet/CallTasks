// instanciando a classe Usuario do pacote modelo e criando seu objeto usuarios
Usuario usuarios = new Usuario();
usuarios.setNome(jTextField1.getText());
usuarios.setCpf(jTextField2.getText());
usuarios.setEmail(jTextField3.getText());
usuarios.setTelefone(jTextField4.getText());

// fazendo a validação dos dados
if ((jTextField1.getText().isEmpty()) || (jTextField2.getText().isEmpty()) || (jTextField3.getText().isEmpty()) || (jTextField4.getText().isEmpty())) {
   JOptionPane.showMessageDialog(null, "Os campos não podem retornar vazios");
}
else {

    // instanciando a classe UsuarioDAO do pacote dao e criando seu objeto dao
    UsuarioDAO dao = new UsuarioDAO();
    dao.adiciona(usuarios);
    JOptionPane.showMessageDialog(null, "Usuário "+jTextField1.getText()+" inserido com sucesso! ");
}

// apaga os dados preenchidos nos campos de texto
jTextField1.setText("");
jTextField2.setText("");
jTextField3.setText("");
jTextField4.setText(""); 
}
