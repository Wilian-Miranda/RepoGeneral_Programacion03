use estudiantes;

select * from usuarios;
select * from estudiantes;

insert into usuarios(users,passwords) values ( "wilian",md5("12345"));

Delimiter $$
create procedure sp_Acceso(
	Pusuario varchar(50),
    Ppassword varchar(50)
)
begin
	select * from tbl_estudiantes a
		where a.users = Pusuario and a.passwords = md5(Ppassword);
end
$$
Delimiter $$
create procedure SP_U_ESTUDIANTES(
	Pid int,
	Pnombres varchar(50),
    Papellidos varchar(50)
)
begin
	update estudiantes a set a.nombres = Pnombres, a.apellidos = Papellidos
		where a.id = Pid;
end$$
Delimiter $$
create procedure SP_D_ESTUDIANTES(
	Pid int
)
begin
	delete from estudiantes a
		where a.id = Pid;
end
$$

call SP_D_ESTUDIANTES(29);
call sp_Acceso("wilian","12345");