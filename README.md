JValidator
==========

OBS: Novas atualizações serão realizadas para o melhor funcionamento e performance.


JValidator v1.0
Última Modificação: 20/06/2011       


JAR criado para realizar a validação dinâmica de JFrames e JInternalFrames
Funciona com JTabbedPanes internos aos JInternalFrames inclusive, realiza a valifação de JTextFields,JTextAreas e JFormattedTextFields.


Descrição dos Métodos
                                                 
                     
  +Valida(JTextField,int): recebe um JTextField e um limite de caracteres, caso   
                           o texto no JTextField não respeito o limite, uma men-  
                           sagem de erro é mostrada.                              
                     
  +Valida(JTextField,String): recebe um JTextField e um tipo de valor em String,  
 case o texto no JTextField não respeite o tipo de   
 valor informado, uma mensagem de erro é mostrada.   
  +Valida(JFrame): recebe um JFrame e captura todos os Components em seu          
                  interior.                       
  +Valida(JInternalFrame): recebe um JInternalFrame e captura todos os Com-       
                          ponents em seu interior.
  +Valida(JInternalFrame,String): recebe um JInternalFrame e captura todos os     
    Components em seu interior, porém captura        
    somente o JPanel com o nome informado no 2º      
    parâmetro(String nome).                          
  -Valida(List<JPanel>): recebe um List de JPanels e através de um foreach,       
                        seleciona JPanel por JPanel e os passa para o método      
                        seguinte.                 
                     
  -Valida(JPanel): recebe um JPanel, e através de um foreach, seleciona todos     
                  os seus Components, caso possua outro JPanel em seu inteiror    
                  faz uma recursiva refinando a varredura.                        
                     
  -Valida(JTextField): método que recebe um JTextField e verifica se o mesmo está 
                      em branco, gerando a String de erro, e adicionando o nome   
                      do JTextField em branco.