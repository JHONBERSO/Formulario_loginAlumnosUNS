# Formulario login (Email y Contraseña),validado en tiempo real Usando Firebase Authentication Android

### 1.4️⃣ **LOGIN**
<img width="392" height="813" alt="image" src="https://github.com/user-attachments/assets/4f567138-bbed-4ee4-86b8-169c2f48c65d" />

la imagen muestra una pantalla de inicio de sesión para una aplicación móvil, en Android Studio.

### 2.4️⃣ **CREAR CUENTA**
<img width="375" height="805" alt="image" src="https://github.com/user-attachments/assets/71b9424c-9ae0-4867-9256-d3cb1eaef9a6" />
<img width="393" height="833" alt="image" src="https://github.com/user-attachments/assets/4dcd11ef-ad21-471e-b393-3e5d01231f88" />

En estas  imagenes se esta verificando, que el usuario escriba correctamente su correo universitario, caso contrario se  mostrara un error en tiempo real si no se cumple con esas reglas, en este caso se ha escrito a proposito mal para darnos cuenta que ,nuestra aplicacion esta cumpliendo con ciertas restricciones, ya que  la manera correcta seria con "@uns.edu.pe"

### 3.4️⃣ **CREAR CUENTA CORRECTAMENTE**
<img width="386" height="812" alt="image" src="https://github.com/user-attachments/assets/bc431f44-b6e4-4f3c-8d37-d36dd84eff66" />

En esta imagen se  puede visualizar que el Uusuario a escrito correctamente su correo universitario y ha obedecido las reglas de la contraseña como el correo, esto se debe a que todo se esta verificando en tiempo real.

### 4.4️⃣ **REGISTRO EXISTOSO**
<img width="386" height="811" alt="image" src="https://github.com/user-attachments/assets/9af75bcb-91d6-4c9b-9a49-646ba6359178" />

Se  puede notar que el registro fue exitoso, y de inmediato me aparece esta ventana para confirmarlo.

### 5.4️⃣ **REGISTRO FALLIDO(intentando crear una cuenta con el mismo correo)**
<img width="382" height="812" alt="image" src="https://github.com/user-attachments/assets/320cf861-44dd-4f49-b60e-76ddc6965b04" />

se  muestra una  notficacion que dice "no se ha podido crear esa cuenta por que  ya esta registrado", pese a que en lo apartados de email y contraseña  no me detecta error.

### 6.4️⃣ **VERIFICACION EN FIREBASE **
<img width="1596" height="681" alt="image" src="https://github.com/user-attachments/assets/fa519a39-f595-4f58-aa5b-88ea046b0110" />

Si se ha registrado en firebase, por lo tanto desde esta pestaña podemos  agregar otra cuenta, eliminar, inhabilitar y restablcer la contraseña e  inclusive eliminarla.

### 7.4️⃣ **INICIO DE SESION FAALLIDO**
<img width="364" height="809" alt="image" src="https://github.com/user-attachments/assets/1e091a25-0297-49d9-9224-67b5705db8be" />

Aqui se  puede visualiar que tambien hay un control en el que se hace la verificacion en tiempo real en caso el usuario intente ingresar otro correo que no cumple con la grafia del correo de la universidad y otra contraseña que sea menor a 6 caracteres.

### 8.4️⃣ **INICIO DE SESION EXITOSO**
<img width="388" height="820" alt="image" src="https://github.com/user-attachments/assets/d3c0f2f8-6692-4434-b086-ec6fd4b1d9a2" />
<img width="374" height="805" alt="image" src="https://github.com/user-attachments/assets/96046d01-e7aa-4fb5-9363-a46f772b7304" />

se ha verificado en tiempo real los datos del usuario  que previamente ya se habia registrado  y con ello intentaremos ingresar a su cuenta nuenvamente para ver si esta registrado correctamente. Dado que  no presenta ningun error de  inmediato nos deja ingresar ingresar a la vista de Informacion del Uusario.

