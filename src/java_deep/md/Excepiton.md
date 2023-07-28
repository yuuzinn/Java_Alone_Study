# Exception

Team Project 중 Exception에 관해 얘기가 나왔고, Checked Exception과 UnChecked Exception이 나와
간단하게 찾아보게 되었다.

### Checked Exception (확인된 예외):
예외 처리 강제: Checked Exception은 컴파일러가 예외 처리를 강제화하는 예외 유형입니다. 
메서드가 Checked Exception을 던질 수 있다면, 
해당 메서드는 반드시 예외를 처리하는 코드(try-catch 블록 또는 throws 선언)를 가지고 있어야 합니다.

- hecked Exception 종류: 예를 들어, FileNotFoundException, IOException 등의 입출력(I/O)과 
관련된 작업에서 발생할 수 있는 많은 Checked Exception이 있습니다.

- 호출자에게 예외 전파: Checked Exception이 발생하면 메서드 내부에서 직접 처리하지 않고, 
호출자에게 예외를 전파하여 처리를 강제합니다.

- try-catch 또는 throws 사용 필요: Checked Exception을 처리하지 않으면 컴파일 오류가 발생하며, 
해당 메서드에서 Checked Exception을 처리하지 않고 무시할 수 없습니다.

### Unchecked Exception (확인되지 않은 예외):
예외 처리 선택: Unchecked Exception은 컴파일러가 예외 처리를 강제하지 않는 예외 유형입니다.
즉, 메서드가 Unchecked Exception을 던질 수 있지만,
예외 처리를 강제하는 코드를 작성하지 않아도 됩니다.

- RuntimeException 하위 클래스: Unchecked Exception은 
대부분 RuntimeException 클래스 및 그 하위 클래스에서 발생합니다. 
예를 들어, NullPointerException, ArrayIndexOutOfBoundsException 등이 있습니다.

- 예외 처리 선택: Unchecked Exception은 개발자가 선택적으로 예외 처리를 할 수 있습니다. 
예외를 처리하지 않으면 런타임에 프로그램이 중단될 수 있습니다.

- try-catch 또는 throws 선택적: Unchecked Exception은 try-catch 블록으로 처리할 수도 있고, 
메서드에서 throws 선언으로 전파할 수도 있지만, 강제로 처리할 필요는 없습니다.

차이점 요약:
- Checked Exception은 예외 처리를 강제합니다. Unchecked Exception은 예외 처리를 강제하지 않습니다.
- Checked Exception은 주로 I/O 작업과 관련된 예외들을 포함합니다. Unchecked Exception은 RuntimeException 클래스 및 하위 클래스에 속하는 예외들을 포함합니다.
- Checked Exception이 발생한 메서드는 해당 예외를 직접 처리하거나, throws 선언으로 호출자에게 예외를 전파해야 합니다. Unchecked Exception은 개발자의 선택에 따라 처리하거나 전파할 수 있습니다.