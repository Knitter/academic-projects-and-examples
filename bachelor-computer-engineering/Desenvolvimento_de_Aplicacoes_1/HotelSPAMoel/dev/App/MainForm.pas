unit MainForm;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, ComCtrls, Menus, ExtCtrls;

type
  THotelGest = class(TForm)
    StatusBar1: TStatusBar;
    Menu: TMainMenu;
    MenuHotelGest: TMenuItem;
    MenuItemExit: TMenuItem;
    MenuItemLogin: TMenuItem;
    N1: TMenuItem;
    N2: TMenuItem;
    MenuItemOptions: TMenuItem;
    MenuHelp: TMenuItem;
    MenuItemAbout: TMenuItem;
    MenuManagement: TMenuItem;
    MenuData: TMenuItem;
    N3: TMenuItem;
    MenuItemLog: TMenuItem;
    MenuItemBookings: TMenuItem;
    MenuItemReservation: TMenuItem;
    MenuItemClients: TMenuItem;
    MenuItemBlackList: TMenuItem;
    N8: TMenuItem;
    MenuItemTax: TMenuItem;
    N6: TMenuItem;
    MenuItemRegistered: TMenuItem;
    MenuItemUsers: TMenuItem;
    MenuItemMenuProdServ: TMenuItem;
    MenuItemMenuRooms: TMenuItem;
    MenuItemLogout: TMenuItem;
    MenuWindow: TMenuItem;
    DateUpdater: TTimer;
    MenuItemExtras: TMenuItem;
    MenuItemDiscount: TMenuItem;
    MenuItemCheckOut: TMenuItem;
    N4: TMenuItem;
    MenuItemSales: TMenuItem;
    procedure MenuItemExitClick(Sender: TObject);
    procedure MenuItemAboutClick(Sender: TObject);
    procedure Login(Sender: TObject);
    procedure FormCloseQuery(Sender: TObject; var CanClose: Boolean);
    procedure MenuItemLogClick(Sender: TObject);
    procedure MenuItemTaxClick(Sender: TObject);
    procedure MenuItemUsersClick(Sender: TObject);
    procedure MenuItemBlackListClick(Sender: TObject);
    procedure MenuItemOptionsClick(Sender: TObject);
    procedure MenuItemLogoutClick(Sender: TObject);
    procedure MenuItemClientsClick(Sender: TObject);
    procedure MenuItemRegisteredClick(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure MenuItemReservationClick(Sender: TObject);
    procedure MenuItemBookingsClick(Sender: TObject);
    //procedure MenuItemReportsClick(Sender: TObject);
    procedure MenuItemMenuProdServClick(Sender: TObject);
    procedure MenuItemMenuRoomsClick(Sender: TObject);
    procedure MenuItemDiscountClick(Sender: TObject);
    procedure MenuItemExtrasClick(Sender: TObject);
    //procedure MenuItemSalesClick(Sender: TObject);
    procedure MenuItemCheckOutClick(Sender: TObject);
    procedure MenuItemSalesClick(Sender: TObject);
  private
    { Private declarations }
    authenticated: Boolean;
    employee: Integer;
    admin: Boolean;
    saveFormPosition: Boolean;
    saveFormSize: Boolean;
    function ShowExistingMDIChild(FormName: String): Boolean;
    procedure UpdateWindowMenuAdd(Title: String; ID: Integer);
    procedure WindowsMenuItemDoAction(Sender: TObject);
    function GetEmployee():Integer;
  public
    { Public declarations }
    procedure AcceptLoginData(Username: String; Password: String);
    procedure UpdateWindowMenuRemove(ID: Integer);
    procedure OptionsFileChanged;
    property Emp: Integer read GetEmployee;
  end;

var
  HotelGest: THotelGest;

implementation

{$R *.dfm}

uses
  About, BlackList, Booking, CheckOut, ClientList, Data, Discount, Employee,
  Extra, Login, LogViewer, Options, ProductNService, Registered, Reports,
  Reservation, Room, Sales, Tax, IniFiles;

{**
 * Returns the current working employee.
 *}
function THotelGest.GetEmployee():Integer;
begin
  Result := employee;
end;

{**
 * Sets various application wide settings.
 *
 * At the form's creation, the config.ini file is red and the form's options are
 * set.
 * Sets the 'Top' and 'Left' and the 'Width and Height' par of attributes.
 * Although the file is always red, only if the user has set the 'save form
 * position' and/or the 'save form size options' are the values used.
 *}
procedure THotelGest.OptionsFileChanged;
var
  ini: TIniFile;
begin
{  try
close connection, change connection string, start connection, re-log user
    HotelGestDataModule.Conn.ConnectionString := '';
    C:\System\Working\HotelSPAMoel\dev\App\ligacao.udl
    HotelGestDataModule.Conn.Connected := True;
  finally
  end; }
  ini := TIniFile.Create(ChangeFileExt(Application.ExeName, '.ini'));
  try
    SaveFormPosition := ini.ReadBool('Options', 'saveposition', False);
    SaveFormSize := ini.ReadBool('Options', 'savesize', False);
    if SaveFormPosition  then
    begin
      Top := ini.ReadInteger('Pos', 'y', 100);
      Left := ini.ReadInteger('Pos', 'x', 100);
    end;
    if SaveFormSize  then
    begin
      Width := ini.ReadInteger('Size', 'width', 640);
      Height := ini.ReadInteger('Size', 'height', 480);
    end;
  finally
    ini.Free;
  end;
//TODO 1: database related actions
end;

{**
 * Generic event code for all menu items of the WindowMenu.
 * Everytime the menu is used, a search for the corresponding form is made
 * through the use of the 'Tag' value. If the form exists, and it should always
 * exist, it is showen.
 *}
procedure THotelGest.WindowsMenuItemDoAction(Sender: TObject);
var
  z: Integer;
begin
  z := 0;
  while (z < Screen.FormCount) and
        (Screen.Forms[z].Tag <> TMenuItem(Sender).Tag) do
    z := z + 1;
  if z <> Screen.FormCount then
    Screen.Forms[z].Show;  
end;

{**
 * Updates the window menu adding a new open window.
 *}
procedure THotelGest.UpdateWindowMenuAdd(Title: String; ID: Integer);
var
  item: TMenuItem;
begin
  if not MenuWindow.Enabled then
    MenuWindow.Enabled := True;

  item := TMenuItem.Create(MenuWindow);
  item.Caption := Title;
  item.Tag := ID;
  item.OnClick := WindowsMenuItemDoAction;
  MenuWindow.Add(item);
end;

{**
 * Updates the window menu removing a new open window.
 *}
procedure THotelGest.UpdateWindowMenuRemove(ID: Integer);
var
  z: Integer;
  deletedItem: TMenuItem;
begin
  z := 0;
  while (z < MenuWindow.Count) and (MenuWindow.Items[z].Tag <> ID) do
    z := z + 1;

  if z <> MenuWindow.Count then
  begin
    deletedItem := MenuWindow.Items[z];
    MenuWindow.Delete(z);
    deletedItem.Free;

    if MenuWindow.Count = 0 then
      MenuWindow.Enabled := False;
  end;
end;

{**
 * AcceptLoginData allows a login form to send the username and password after
 * the user presses the send/ok button.
 * The procedure sets the statusbar text showing a logged in/not logged in
 * message.
 *
 * Params:
 *    Username, the username to lookup in the employee's table
 *    Password, the employee's password to lookup in the database
 *}
procedure THotelGest.AcceptLoginData(Username: String; Password: String);
begin
//TODO 1: login
  HotelGestDataModule.ADOQueryAuthenticate.Parameters.ParamByName('usrn').Value := Username;
  HotelGestDataModule.ADOQueryAuthenticate.Parameters.ParamByName('pass').Value := Password;
  HotelGestDataModule.ADOQueryAuthenticate.Open;
  if HotelGestDataModule.ADOQueryAuthenticate.RowsAffected = 1 then
  begin
    authenticated := True;
    employee := HotelGestDataModule.ADOQueryAuthenticate.FieldByName('id').Value;
    if HotelGestDataModule.ADOQueryAuthenticate.FieldByName('emp_type').Value = 'N' then
      admin := False;
  end;
  if authenticated  then
  begin
    StatusBar1.Panels[1].Text := 'Ligado';
    MenuItemLogout.Enabled := True;
    if admin then
      MenuManagement.Enabled := True;
  end
  else
    StatusBar1.Panels[1].Text := 'Desligado';
end;

{**
 * Searches all available forms using the 'Screen' object. If a form with the
 * given name is found the cicle breaks and the form is shown using the 'Show'
 * procedure..
 *
 * Params:
 *    FormName, a string with the name of form's class to search.
 *
 * Returns a boolean indicating if the form was found.
 *}
function THotelGest.ShowExistingMDIChild(FormName: String): Boolean;
var
  z: Integer;
  alreadyExists: Boolean;
begin
  alreadyExists := False;

  z := 0;
  while (z < Screen.FormCount) and
        (not Screen.Forms[z].ClassNameIs(FormName)) do
    z := z + 1;

    if z <> Screen.FormCount then
    begin
      alreadyExists := True;
      Screen.Forms[z].Show;
    end;
  Result := alreadyExists;
end;

//Delphi generated events follows...

{**
 * Allows the form data to be saved in the 'config.ini' file.
 *}
procedure THotelGest.FormClose(Sender: TObject; var Action: TCloseAction);
var
  ini: TIniFile;
begin
  ini := TIniFile.Create(ChangeFileExt(Application.ExeName, '.ini'));
  try
    if SaveFormPosition  then
    begin
      ini.WriteBool('Options', 'saveposition', SaveFormPosition);
      ini.WriteInteger('Pos', 'y', Top);
      ini.WriteInteger('Pos', 'x', Left);
    end;
    if SaveFormSize  then
    begin
      ini.WriteBool('Options', 'savesize', SaveFormSize);
      ini.WriteInteger('Size', 'width', Width);
      ini.WriteInteger('Size', 'heigh', Height);
    end;
  finally
    ini.Free;
  end;
end;

{**
 * Shows close confirmation dialog and prevents closing the form if the user
 * wants to.
 *}
procedure THotelGest.FormCloseQuery(Sender: TObject; var CanClose: Boolean);
begin
  if MessageDlg('Tem a certeza que deseja sair?', mtConfirmation, [mbYes, mbNo],
                0) = mrNo then
    CanClose := False;
end;

{**
 * Set various application wide parameters.
 *
 * The current date is shown in the status bar.
 *}
procedure THotelGest.FormCreate(Sender: TObject);
begin
  OptionsFileChanged;
  StatusBar1.Panels[2].Text := DateToStr(Date());
end;

{**
 * Shows the login dialog.
 *}
procedure THotelGest.Login(Sender: TObject);
var
  login: TLoginForm;
begin
  login := TLoginForm.Create(Self);
  login.ShowModal;
end;

{**
 * Shows the About dialog.
 *}
procedure THotelGest.MenuItemAboutClick(Sender: TObject);
var
  about: TAboutForm;
begin
  about := TAboutForm.Create(Self);
  about.ShowModal;
end;

{**
 * Shows the black list form allowing the user to manage items in the
 * corresponding table.
 *}
procedure THotelGest.MenuItemBlackListClick(Sender: TObject);
var
  list: TBlackListForm;
begin
  if not ShowExistingMDIChild('TBlackListForm') then //Hardcoded String :(
  begin
    list := TBlackListForm.Create(Self);
    UpdateWindowMenuAdd(list.Caption, list.Tag);
    list.Show;

  end;
end;

{**
 * Shows the booking form.
 *}
procedure THotelGest.MenuItemBookingsClick(Sender: TObject);
var
  log: TBookingForm;
begin
  if not ShowExistingMDIChild('TBookingForm') then //Hardcoded String :(
  begin
    log := TBookingForm.Create(Self);
    UpdateWindowMenuAdd(log.Caption, log.Tag);
    log.Show;
  end;
end;

{**
 * Shows the clients' list form.
 *}
procedure THotelGest.MenuItemCheckOutClick(Sender: TObject);
var
  check: TCheckOutForm;
begin
  if not ShowExistingMDIChild('TCheckOutForm') then //Hardcoded String :(
  begin
    check := TCheckOutForm.Create(Self);
    UpdateWindowMenuAdd(check.Caption, check.Tag);
    check.Show;
  end;
end;

procedure THotelGest.MenuItemClientsClick(Sender: TObject);
var
  client: TClientListForm;
begin
  if not ShowExistingMDIChild('TClientListForm') then //Hardcoded String :(
  begin
    client := TClientListForm.Create(Self);
    UpdateWindowMenuAdd(client.Caption, client.Tag);
    client.Show;
  end;
end;

procedure THotelGest.MenuItemDiscountClick(Sender: TObject);
var
  discount: TDiscountForm;
begin
  if not ShowExistingMDIChild('TDiscountForm') then //Hardcoded String :(
  begin
    discount := TDiscountForm.Create(Self);
    UpdateWindowMenuAdd(discount.Caption, discount.Tag);
    discount.Show;
  end;
end;

{**
 * Closes the main application form.
 *}
procedure THotelGest.MenuItemExitClick(Sender: TObject);
begin
  Close;
end;

procedure THotelGest.MenuItemExtrasClick(Sender: TObject);
var
  extra: TExtraForm;
begin
  if not ShowExistingMDIChild('TExtraForm') then //Hardcoded String :(
  begin
    extra := TExtraForm.Create(Self);
    UpdateWindowMenuAdd(extra.Caption, extra.Tag);
    extra.Show;
  end;
end;

{**
 * Shows the log viewer form.
 *}
procedure THotelGest.MenuItemLogClick(Sender: TObject);
var
  log: TLogViewerForm;
begin
  if not ShowExistingMDIChild('TLogViewerForm') then //Hardcoded String :(
  begin
    log := TLogViewerForm.Create(Self);
    UpdateWindowMenuAdd(log.Caption, log.Tag);
    log.Show;
  end;
end;

{**
 * Closes the user's login to the database.
 *}
procedure THotelGest.MenuItemLogoutClick(Sender: TObject);
begin
  employee := -1;
  authenticated := False;
  MenuItemLogin.Enabled := False;
  MenuManagement.Enabled := False;
  //TODO 1: logout.
end;

{**
 * Shows the products' form.
 *}
procedure THotelGest.MenuItemMenuProdServClick(Sender: TObject);
var
  log: TProductNServiceForm;
begin
  if not ShowExistingMDIChild('TProductNServiceForm') then //Hardcoded String :(
  begin
    log := TProductNServiceForm.Create(Self);
    UpdateWindowMenuAdd(log.Caption, log.Tag);
    log.Show;
  end;
end;

{**
 * Shows the rooms' form.
 *}
procedure THotelGest.MenuItemMenuRoomsClick(Sender: TObject);
var
  log: TRoomForm;
begin
  if not ShowExistingMDIChild('TRoomForm') then //Hardcoded String :(
  begin
    log := TRoomForm.Create(Self);
    UpdateWindowMenuAdd(log.Caption, log.Tag);
    log.Show;
  end;
end;

{**
 * Shows the options dialog
 *}
procedure THotelGest.MenuItemOptionsClick(Sender: TObject);
var
  opt: TOptionsForm;
begin
  opt := TOptionsForm.Create(Self);
  opt.ShowModal;
end;

{**
 * Shows the registered users' from.
 *}
procedure THotelGest.MenuItemRegisteredClick(Sender: TObject);
var
  reg: TRegisteredForm;
begin
  if not ShowExistingMDIChild('TRegisteredForm') then //Hardcoded String :(
  begin
    reg := TRegisteredForm.Create(Self);
    UpdateWindowMenuAdd(reg.Caption, reg.Tag);
    reg.Show;
  end;
end;

{**
 * Shows the reservation form.
 *}
procedure THotelGest.MenuItemReservationClick(Sender: TObject);
var
  reserv: TReservationForm;
begin
  if not ShowExistingMDIChild('TReservationForm') then //Hardcoded String :(
  begin
    reserv := TReservationForm.Create(Self);
    UpdateWindowMenuAdd(reserv.Caption, reserv.Tag);
    reserv.Show;
  end;
end;

//
procedure THotelGest.MenuItemSalesClick(Sender: TObject);
var
  sale: TSalesForm;
begin
  if not ShowExistingMDIChild('TSalesForm') then //Hardcoded String :(
  begin
    sale := TSalesForm.Create(Self);
    UpdateWindowMenuAdd(sale.Caption, sale.Tag);
    sale.Show;
  end;
end;

{**
 * Shows the tax form.
 *}
procedure THotelGest.MenuItemTaxClick(Sender: TObject);
var
  tax: TTaxForm;
begin
  if not ShowExistingMDIChild('TTaxForm') then //Hardcoded String :(
  begin
    tax := TTaxForm.Create(Self);
    UpdateWindowMenuAdd(tax.Caption, tax.Tag);
    tax.Show;
  end;
end;

{**
 * Shows the employee's list.
 *}
procedure THotelGest.MenuItemUsersClick(Sender: TObject);
var
  user: TEmployeeForm;
begin
  if not ShowExistingMDIChild('TEmployeeForm') then //Hardcoded String :(
  begin
    user := TEmployeeForm.Create(Self);
    UpdateWindowMenuAdd(user.Caption, user.Tag);
    user.Show;
  end;
end;

end.
